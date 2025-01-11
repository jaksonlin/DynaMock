# DynaMock Config

Solving the problem of how to mock dynamic data containers during unit testing.

## What is a Dynamic Data Container?

A dynamic data container is a class that is used to store dynamic data; `DemoDynamicObject` in the example from `src/main/java/test/com/github/jaksonlin/dynamock/model/DemoDynamicObject.java` is an example of a dynamic data container.

## What is the difficulty of mocking dynamic data containers?

The difficulty of mocking dynamic data containers is that the methods to set the value of a property/attribute of a dynamic data container are not statically defined, when a dynamic data container go through multiple level of method calls, developer get hard to identify what are the necessary fields/properties/attributes that need to be mocked, so that they won't get a `NullPointerException` or `ClassCastException` during unit testing.

## Why Dynamic Data Container is necessary?

In the SaaS world, when the standard feature set is not enough to meet different customer's requirements, the SaaS provider will provide a way to customize the feature set, using statically defined classes and methods will soon get into a dead end, because the developer will have to update the codebase every time when the customer's requirement changes, which is not scalable.

Dynamic Data Container is a way to solve this problem, for standard feature set, the data model is predefined, when it comes to customization, because the backing store is dynamic, we can easily add new fields/properties/attributes to the dynamic data container, and use plugin mechanism to implement the logic to set the value of a property/attribute of the dynamic data container.

But this also brings a new problem, how to mock the dynamic data container during unit testing?

## Solution

To solve this problem, we need to collect the information of the dynamic data container in the context of a target method call;
when we need to test a target method, and the method depends on a dynamic data container, we need to go upper level of the method call, and find out the methods that are used to set the value of a property/attribute of the dynamic data container, and when the top level method is found, then we can do a drill down analysis from top level method to the target method, and identify the necessary fields/properties/attributes that need to be mocked, so that we won't get a `NullPointerException` or `ClassCastException` during unit testing.

This requires a tool to collect the information of the dynamic data container in the context of a target method call, and track down the methods that are used to set the value of a property/attribute of the dynamic data container. 

In our solution, the backend of static analysis is `SootUp`, and this project is a tool to help to collect the information and generate the mocking code for the dynamic data container.

And Because the dynamic data container can be defined in different way, we need to provide a way to configure the dynamic data container, so that the tool can understand how dynamic data is being populated, regardless of the specific class names or method names.




## 1. TA1: Configurable Dynamic Data Setter Identification

As a tool user, I want to be able to configure patterns or rules to identify methods in the target codebase that are used to set attributes/properties of dynamic data containers, so that the tool can understand how dynamic data is being populated, regardless of the specific class names or method names.

Tasks:

Implement functionality to read configuration (e.g., from a file or command-line arguments).
Support configuration based on:

Class name patterns (regex).
Method name patterns (regex).
Method parameter types and order (e.g., a String followed by Object).
(Optional) Annotations to mark setter methods.






