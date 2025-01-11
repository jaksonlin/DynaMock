# DynaMock Config

Solving the problem of how to mock dynamic data containers during unit testing.

## What is a Dynamic Data Container?

A dynamic data container is a class that is used to store dynamic data; `DemoDynamicObject` in the example from `src/main/java/test/com/github/jaksonlin/dynamock/model/DemoDynamicObject.java` is an example of a dynamic data container.

## Why Dynamic Data Container is necessary?

In the SaaS world, when the standard feature set is not enough to meet different customer's requirements, we need to provide a way to allow extension or customize the feature set; however,using statically defined classes and methods will soon get into a dead end, because the developer will have to update the codebase every time when the customer's requirement changes, which is not scalable.

Dynamic Data Container is a way to solve this problem, for standard feature set, the data model is predefined as a set of meta data backed by a config file and loaded at runtime into a dynamic data container; when it comes to customization, because the backing store is dynamic, we can easily add new fields/properties/attributes to the dynamic data container, and then use plugin mechanism to implement the extension of the customized feature set.

But this also brings a new problem, how to mock the dynamic data container during unit testing?


## What is the difficulty of mocking dynamic data containers?

The difficulty of mocking dynamic data containers is that the extension field/property/attribute is not statically defined  , when a dynamic data container go through multiple level of method calls, and update the extension field/property/attribute, it ends up a black box to the developer, no one knows which field/property/attribute has been updated, mocking the dynamic data container will be a nightmare.


## Solution

To solve this problem, when we need to test a target method that uses/depends on a dynamic data container, we need to track all the way up to the level that we feel ok to manually create inital data, and then drill down to the target method, collecting all the modification of the dynamic data container, and generate the mocking code for it.









