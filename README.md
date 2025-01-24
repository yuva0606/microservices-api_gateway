# API Gateway - Ecommerce BackEnd

## Overview
This repository contains the **API Gateway** for the **Ecommerce BackEnd** application, which is designed to manage all incoming traffic and route requests to the appropriate microservices. The API Gateway simplifies communication across services by acting as a single entry point, ensuring smooth and secure data flow within the system. It is configured to validate JWT tokens, apply role-based access, and enrich requests with user details, thus enhancing both security and scalability.

## Purpose
The **API Gateway** plays a critical role in the microservices architecture by:
- **Centralizing Access**: Serving as the only public entry point for client requests to reach backend services.
- **Enforcing Security**: Validating JWT tokens for secure endpoints and forwarding user roles and details for service-specific authorization.
- **Streamlining Communication**: Routing requests to the designated services (User, Product, Inventory, Order) based on predefined paths and applying custom filters where needed.

This setup provides a secure, organized, and efficient way to handle interactions within the **Ecommerce BackEnd** application.

![E-commerce project](https://github.com/user-attachments/assets/8bb5e1c0-1b24-4213-80b9-3b4345944f41)
