A small ongoing parallel change practice
---

#### Current Status
We have a specialized shop where we sell our trademark parroty food! It's a product idea that we had long ago, and we 
decided to launch a website to sell it and get our parroty friends happier!

With time, our shop has gained some track, and we now want to prepare to sell other products. Apparently, our code
is not so ready for it just yet.

#### Objective
We want to refactor the code to be able to start adding those new sweet products in an easy way!

Since we only had 1 product until now, the code may be a little too simplistic. Our objective here is to be able to 
have a method that allows us to place an **Order**, the new concept!

That **Order** should be associated with a **Customer**, and must have the **Product** as well as the 
**Number of Products** purchased in the **Order**.

For now, we only need **Product** to have a **Name** and a **Price** settled in **coins**, our currency.

Ideally:

```salesService.placeOrder(Order order)```

And the code still showing the same behavior as it does today, check the tests!
