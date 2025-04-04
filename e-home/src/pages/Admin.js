import React, { useState } from 'react';
import { Container, Row, Col, Form, Button } from 'react-bootstrap';
import toast from 'react-hot-toast';
import Layout from '../Components/Layout/Layout';
import axios from 'axios';
const Admin = () => {
  // State for form fields
  const [product, setProduct] = useState({
    name: '',
    image: '',
    brand: '',
    category: '',
    description: '',
    price: '',
    countInStock: '',
    rating: '',
    numReviews: '',
  });

  // Handle form input changes
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setProduct((prev) => ({ ...prev, [name]: value }));
  };  

  // Handle form submission
  const handleSubmit = async (e) => {
   e.preventDefault();
    try {
      console.log(product);
      const API_URL = "/api/auth/products/addPro";
      const res= await axios.post(API_URL,{
        name: product.name,
        image: product.image,
        brand: product.brand,
        category: product.category,
        description: product.description,
        price: Number(product.price),
        countInStock: Number(product.countInStock),
        rating: Number(product.rating),
        numReviews: Number(product.numReviews),
      });
      toast.success("Product added successfully"); // Add success feedback
    // Optionally reset form after success
    setProduct({
      name: '',
      image: '',
      brand: '',
      category: '',
      description: '',
      price: '',
      countInStock: '',
      rating: '',
      numReviews: '',
    });
    } catch (error) {
      console.log(error);
      toast.error("Something went wrong");
    }
    console.log(product);

  };

  return (
    <Layout>
    <Container fluid className="d-flex justify-content-center align-items-center min-vh-100">
      <Row className="w-100 justify-content-center">
        <Col md={8} lg={6} className="form-container">
        <div className="title-holder">
          <h2>welcome to Bshop</h2>
          <div className="subtitle">Add products here:</div>
        </div>
          <Form onSubmit={handleSubmit}>
            <Row>
              <Col md={6}>
                <Form.Group controlId="name" className="mb-3">
                  <Form.Label>Name</Form.Label>
                  <Form.Control
                    type="text"
                    name="name"
                    value={product.name}
                    onChange={handleInputChange}
                    placeholder="Enter product name"
                    required
                  />
                </Form.Group>
              </Col>
            </Row>
            <Form.Group controlId="image" className="mb-4">
              <Form.Label>Image URL</Form.Label>
              <Form.Control
                type="text"
                name="image"
                value={product.image}
                onChange={handleInputChange}
                placeholder="Enter image URL"
                required
              />
            </Form.Group>
            <Row>
              <Col md={6}>
                <Form.Group controlId="brand" className="mb-3">
                  <Form.Label>Brand</Form.Label>
                  <Form.Control
                    type="text"
                    name="brand"
                    value={product.brand}
                    onChange={handleInputChange}
                    placeholder="Enter brand"
                    required
                  />
                </Form.Group>
              </Col>
              <Col md={6}>
                <Form.Group controlId="category" className="mb-3">
                  <Form.Label>Category</Form.Label>
                  <Form.Control
                    type="text"
                    name="category"
                    value={product.category}
                    onChange={handleInputChange}
                    placeholder="Enter category"
                    required
                  />
                </Form.Group>
              </Col>
            </Row>
            <Form.Group controlId="description" className="mb-3">
              <Form.Label>Description</Form.Label>
              <Form.Control
                as="textarea"
                rows={3}
                name="description"
                value={product.description}
                onChange={handleInputChange}
                placeholder="Enter product description"
                required
              />
            </Form.Group>

            <Row>
              <Col md={6}>
                <Form.Group controlId="price" className="mb-3">
                  <Form.Label>Price</Form.Label>
                  <Form.Control
                    type="number"
                    name="price"
                    value={product.price}
                    onChange={handleInputChange}
                    placeholder="Enter price"
                    required
                  />
                </Form.Group>
              </Col>
              <Col md={6}>
                <Form.Group controlId="countInStock" className="mb-3">
                  <Form.Label>Count in Stock</Form.Label>
                  <Form.Control
                    type="number"
                    name="countInStock"
                    value={product.countInStock}
                    onChange={handleInputChange}
                    placeholder="Enter stock count"
                    required
                  />
                </Form.Group>
              </Col>
            </Row>

            <Row>
              <Col md={6}>
                <Form.Group controlId="rating" className="mb-3">
                  <Form.Label>Rating</Form.Label>
                  <Form.Control
                    type="number"
                    name="rating"
                    value={product.rating}
                    onChange={handleInputChange}
                    placeholder="Enter rating (0-5)"
                    min="0"
                    max="5"
                    step="0.1"
                    required
                  />
                </Form.Group>
              </Col>
              <Col md={6}>
                <Form.Group controlId="numReviews" className="mb-3">
                  <Form.Label>Number of Reviews</Form.Label>
                  <Form.Control
                    type="number"
                    name="numReviews"
                    value={product.numReviews}
                    onChange={handleInputChange}
                    placeholder="Enter number of reviews"
                    required
                  />
                </Form.Group>
              </Col>
            </Row>

           

            

            <div className="d-flex justify-content-center">
              <Button variant="primary" type="submit" className="px-4 py-2">
                Add Product
              </Button>
            </div>
          </Form>
        </Col>
      </Row>
    </Container>
    </Layout>
  );
};

export default Admin;