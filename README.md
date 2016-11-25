# Overview

This is starter template for writing Android apps using **Clean architecture**.

This app supports **API 15 and above**.

## Layers from outside to inside

1. ui : ui self and relative tools.
2. presentation : ui logic of interaction and domain connector.
3. repository : data interface and mapping data
3. data : managing data, Caching data, Encrypting data...
4. domain : Business rule.

## Data flow from outside to inside

ui **->** presentation **->** domain **->** storage(repository **->** data)

## Data flow from inside to outside

storage(repository **->** data) **->** domain **->** presentation **->** ui