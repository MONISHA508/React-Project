import React from 'react';
import { Container, Col, Button, Image } from 'react-bootstrap';
import thankyouImage from '../assets/images/thankyou.jpeg';
import Layout from "../Components/Layout/Layout";

const OrderConfirmation = () => {
  return (
    <Layout title={"Thank You - Ecommerce app"}>
    <section id="contact" className="block contact-block">
    <Container className="-5">
        <Col md={{ span: 6, offset: 3 }}>
          <div className="text-center">            
            <h2>Your order has been successfully placed!</h2>
            <p>We appreciate your interest.</p>
            <img
                src={thankyouImage}
                alt="Thank You"
                className="Thankyou-image"
                style={{ width: '500px', height: '300px' }}
              />
            <Button variant="primary" href="/" className="mt-3">
              Continue Shopping
            </Button>
          </div>
        </Col>
    </Container>
    </section>
    </Layout>
  );
};

export default OrderConfirmation;