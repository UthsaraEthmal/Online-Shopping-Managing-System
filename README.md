# Online-Shopping-Managing-System
Clothing and Electronics Classes: These classes extend the Product class and represent distinct types of products available for purchase. Clothing includes properties such as size and color, while Electronics includes properties like brand and warranty period. Both classes implement methods to display product information and are serializable for object storage.
Main Class: Serving as the application's entry point, the Main class initializes the shopping management system and enters a loop to handle user interactions through a menu-based interface. It allows users to perform various actions like adding products, deleting products, and printing product lists.
Product Class: An abstract class representing generic products, it includes common attributes like product ID, name, quantity, and price. Subclasses override abstract methods to display product information based on their specific type. The class is designed to be serializable for storage and retrieval of product data.
ShoppingCart and ShoppingManager Interfaces: These interfaces define methods for managing shopping carts and products within the system. They provide functionalities such as adding products to the cart, deleting products, printing product lists, and displaying a menu for user interaction.
User Class: This class models users of the shopping system, storing their usernames and passwords. It is serializable for saving and loading user data.
Together, these components form the backbone of a shopping management system, enabling users to browse, add, and manage products within a virtual shopping environment
