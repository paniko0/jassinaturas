jassinaturas Client Library for Java
============================================

Client library to integrates Moip Assinaturas on Java.

Moip Assinaturas is a Moip's project that makes recurrence charges. It allows to create plans, customers, subscriptions and so on.

API documentation is available at: http://moiplabs.github.io/assinaturas-docs/api.html


 - Author: Danillo Souza

Still working on it
====================

# Using
====================

```java
	Plan toCreate = new Plan();
	toCreate
		.withCode("plan001")
		.withDescription("Plano de Teste")
		.withName("Plano de Teste")
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


Thanks
====================

Rodrigo Saito - @rodrigosaito

Contributing
====================

== Copyright

Copyright (c) 2014 Danillo Souza. Distributed under the MIT license. See LICENSE for details.