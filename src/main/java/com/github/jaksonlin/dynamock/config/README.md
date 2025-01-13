# DynaMock Config

## 1. TA1: Configurable Dynamic Data Setter Identification

As a tool user, I want to be able to configure patterns or rules to identify methods in the target codebase that are used to set attributes/properties of dynamic data containers, so that the tool can understand how dynamic data is being populated, regardless of the specific class names or method names.

Tasks:

Implement functionality to read configuration (e.g., from a file or command-line arguments).
Support configuration based on:

Class name patterns (regex).
Method name patterns (regex).
Method parameter types and order (e.g., a String followed by Object).
(Optional) Annotations to mark setter methods.






