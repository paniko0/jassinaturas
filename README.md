jassinaturas Client Library for Java
============================================

Client library to integrates Moip Assinaturas on Java.

Moip Assinaturas is a Moip's project that makes recurrence charges. It allows to create plans, customers, subscriptions and so on.

API documentation is available at: http://moiplabs.github.io/assinaturas-docs/api.html


 - Author: Danillo Souza

Still working on it
====================

# Using

First of all, you'll have to instanciate a new Assinaturas passing your credentials and whitch environment you want to connect.

```java
	Assinaturas assinaturas = new Assinaturas(new Authentication("YOUR_TOKEN", "YOUR_SECRET"));
```

### Plans

Creating a new plan:

```java
	Plan toCreate = new Plan();
	toCreate
		.withCode("YOR_PLAN_CODE")
		.withDescription("YOUR_PLAN_DESCRIPTION")
		.withName("YOUR_PLAN_NAME")
		.withAmount(1000)
        .withSetupFee(100)
        .withBillingCycles(1)
        .withPlanStatus(PlanStatus.ACTIVE)
        .withMaxQty(10)
        .withInterval(new Interval()
        				.withLength(10)
        				.withUnit(Unit.MONTH))
        .withTrial(new Trial()
        				.withDays(10)
        				.enabled());
```

After that you have to call following method:

```java
	Plan created = assinaturas.plan().create(toCreate);
```

Listing all plans:

```java
	List<Plan> plans = assinaturas.plan().list();
```

Getting a single plan:

```java
	Plan plan = assinaturas.plan().show("YOUR_PLAN_CODE");
```

Updating a plan:

To update a plan, you should inform your new plan params, creating a new object of Plan and passing it to update method

```java
	Plan toUpdate = new Plan();
    toUpdate.withCode("PLAN_CODE_TO_UPDATE")
    		.withDescription("PLAN_NEW_DESCRIPTION")
    		.withName("PLAN_NEW_NAME")
            .withAmount(10000)
            .withSetupFee(1000)
            .withBillingCycles(10)
            .withPlanStatus(PlanStatus.INACTIVE)
            .withMaxQty(100)
            .withInterval(new Interval()
            				.withLength(100)
            				.withUnit(Unit.DAY))
            .withTrial(new Trial()
            				.withDays(5)
            				.disabled());
```

After informing what you want to update, just call the following method:

```java
    Plan plan = assinaturas.plan().update(toUpdate);
```

Activating a plan:

```java
	Plan plan = assinaturas.plan().active("YOUR_PLAN_CODE");
```

Inactivating a plan:

```java
	Plan plan = assinaturas.plan().inactive(toInactivate);
```


Thanks
====================

Rodrigo Saito - @rodrigosaito

Contributing
====================

== Copyright

Copyright (c) 2014 Danillo Souza. Distributed under the MIT license. See LICENSE for details.