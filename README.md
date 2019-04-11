# RAVE JAVA 🍻
---
Services implemented are:
---
- Card payment
- Mobile money
- Payment Validation
- Virtual cards
- QR payments
- Bills
- Ebills
- BVN Validation
- Refunds
- Tokenized Charge
- PaymentPlan
- Subscriptions
- Bank payments

---
How to install:
---
There are two ways to install this.

## METHOD 1:
Download RAVE-JAVA
Add jar file as a Module to your Java project:
On Intellij IDEA: File -> Project Structure -> Modules -> Dependencies Tab -> Add -> JARs or Directories -> Attach jar

On Netbeans: Project properties -> Libraries -> Compile -> ADD JAR/folder -> Add Jar

## METHOD 2:
## Maven users
Add this dependency to your project's POM: 

```java
<dependency>
 <groupId>com.flutterwave</groupId>
    <artifactId>Rave-Java</artifactId>
    <version>1.0</version>
</dependency>
```

---

Usage:
---

## Direct Charge
```java
cardPayment cardPayment = new cardPayment();
cardLoad cardload = new cardLoad cardload();
cardload.setPublic_key(PBFPubKey);
cardload.setCardno(cardno);
cardload.setCvv(cvv);
cardload.setExpirymonth(expirymonth);
cardload.setCurrency(currency);
cardload.setCountry(country);
cardload.setAmount(amount);
cardload.setEmail(email);
cardload.setPhonenumber(phonenumber);
cardload.setfirstname(firstname);
cardload.setLastname(lastname);
cardload.setMetaname(metaname);
cardload.setMetaValue(metavalue);
cardload.setExpiryyear(exp_year);
cardload.setRedirect_url(redirect_url);
cardload.setDevice_fingerprint(device_fingerprint);
cardload.setEncryption_key(encryption_key);
cardload.setTest(test);
//set test to 1 if sandbox and 0 if live
  
String response = cardPayment.doflwcardpayment(cardload);

JSONObject myObject = new JSONObject(response);

if(myObject.optString("suggested_auth").equals("PIN"))
{
  //get PIN fom customer
  cardload.setPin(PIN);
  cardload.setSuggested_auth("PIN");
  String response_one = cardPayment.doflwcardpayment(cardload);
  
JSONObject iObject = new JSONObject(response_one);
JSONObject Object = iObject.optJSONObject("data");
  
String transaction_reference = Object.optString("flwRef");
  
validateCardCharge validatecardcharge = new validateCardCharge();
validateCardPayload validatecardpayload = new validateCardPayload();
validatecardpayload.setPBFPubKey(PBFPubKey);
validatecardpayload.setTransaction_reference(transaction_reference);
validatecardpayload.settest(test);
validatecardpayload.setOtp(OTP);
  
response = validatecardcharge.doflwcardvalidate(validatecardpayload);
}
else if(myObject.optString("suggested_auth").equals("NOAUTH_INTERNATIONAL"))
{
  //billing info - billingzip, billingcity, billingaddress, billingstate, billingcountry
  cardload.setBillingaddress(Billingaddress);
  cardload.setBillingcity(Billingcity);
  cardload.setBillingcountry(Billingcountry);
  cardload.setBillingstate(Billingstate);
  cardload.setBillingzip(Billingzip);
  cardload.setSuggested_auth("NOAUTH_INTERNATIONAL");
  String response_one = cardPayment.doflwcardpayment(cardload);
  
JSONObject iObject = new JSONObject(response_one);
JSONObject Object = iObject.optJSONObject("data");
  
String transaction_reference = Object.optString("flwRef")
  
validateCardCharge validatecardcharge = new validateCardCharge();
validateCardPayload validatecardpayload = new validateCardPayload();
validatecardpayload.setPBFPubKey(PBFPubKey);
validatecardpayload.setTransaction_reference(transaction_reference);
validatecardpayload.settest(test);
validatecardpayload.setOtp(OTP);
  
response = validatecardcharge.doflwcardvalidate(validatecardpayload);
}
else if(myObject.optString("authurl")!="N/A")
{
  //load the url in an IFRAME
}

return response;
```

## Mobile Money
```java
mobileMoney mobileMoney = new mobileMoney();
mobilemoneyPayload mobilemoneyPayload = new mobilemoneyPayload();
mobilemoneyPayload.setPBFPubKey(PBFPubKey);
mobilemoneyPayload.setCurrency(currency);
mobilemoneyPayload.setAmount(amount);
mobilemoneyPayload.setPhonenumber(phonenumber);
mobilemoneyPayload.setEmail(email);
mobilemoneyPayload.setFirstname(firstname);
mobilemoneyPayload.setLastname(lastname);
mobilemoneyPayload.setNetwork(narration);
mobilemoneyPayload.setMetaname(metaname);
mobilemoneyPayload.setCountry(country);
mobilemoneyPayload.setMetavalue(metavalue);
mobilemoneyPayload.setDevice_fingerprint(device_fingerprint);
mobilemoneyPayload.setPayment_type(Payment_type);
mobilemoneyPayload.setEncryption_key(encryption_key);
mobilemoneyPayload.setPublic_key(pub_key);
mobilemoneyPayload.setTest(test);
//set test to 1 if sandbox and 0 if live

String response = mobileMoney.domobilemoney(mobilemoneyPayload);

return response; 
```

## QR code
```java
qrPayments qrPayments = new qrPayments();
qrcodePayload qrcodepayload = new qrcodePayload();
qrcodepayload.setPBFPubKey(PBFPubKey);
qrcodepayload.setAmount(amount);
qrcodepayload.setTxref(teRef);
qrcodepayload.setPayment_Type(payment_type);
qrcodepayload.setDevice_fingerprint(Device_fingerprint);
qrcodepayload.setMetaname(metaname);
qrcodepayload.setMetavalue(metavalue);
qrcodepayload.setEmail(email);
qrcodepayload.setPublic_key(pub_key);
qrcodepayload.setTest(test);
//set test to 1 if sandbox and 0 if live

String response = qrPayments.doflwqrpayment(qrcodepayload);
```

## Bills

```java
bills bills = new bills();
BillModel billmodel = new BillModel();
billmodel.setCustomerId(CustomerId);
billmodel.setReference(Reference);
billmodel.setAmount(amount);
billmodel.setIsAirtime(IsAirtime);
billmodel.setBillername(billername);
billmodel.setSecretkey(sevretkey);
billmodel.setTest(test);
//set test to 1 if sandbox and 0 if live

bills.dobillpayment(billmodel);
```

## BVN Validation
```java
bvnValidation bvnvalidation = new bvnValidation();
bvnload bvnload = new bvnload();
bvnload.setBvn(bvn)
bvnload.setTest(test)
//set test to 1 if sandbox and 0 if live

String response = bvnvalidation(bvnload);
```

## Payment Plans
```java

paymentplan paymentplan = new paymentplan();
pamentplancreatepayload pamentplancreatepayload = new pamentplancreatepayload();
pamentplancreatepayload.setAmount(amount);
pamentplancreatepayload.setName(name);
pamentplancreatepayload.setIntervale(interval);
pamentplancreatepayload.setDuration(duration);
pamentplancreatepayload.setRef(ref);

String response = paymentplan.docreatepayment(pamentplancreatepayload);

return response;
```

## Virtual Cards
Sample Code to create a virtual card.

```java 
virtualCards virtualCards = new virtualCards();
virtualcardpayload virtualcardpayload = new virtualcardpayload():
virtualcardpayload.setCurrency(currency);
virtualcardpayload.setAmount(amount);
virtualcardpayload.setBilling_name(billing_name);
virtualcardpayload.setBilling_address(billing_Address);
virtualcardpayload.setBilling_city(billing_city);
virtualcardpayload.setBilling_state(billing_state);
virtualcardpayload.setBilling_postal_code(billing_postal_code);
virtualcardpayload.setSecret_Key(secret_key);
virtualcardpayload.setTest(test);

String response = virtualCards.dovirtualcardcreate(virtualcardpayload);
```

Sample Code to get for a virtual card.
```java 
virtualCards virtualCards = new virtualCards();
virtualcardpayload virtualcardpayload = new virtualcardpayload():
virtualcardpayload.setId(id);
virtualcardpayload.setSecret_Key(secret_key);
virtualcardpayload.setTest(test);

String response = virtualCards.dovirtualcardsearch(virtualcardpayload);
```

Sample Code to List virtual cards.
```java
virtualCards virtualCards = new virtualCards();
virtualcardpayload virtualcardpayload = new virtualcardpayload():
virtualcardpayload.setPage(page);
virtualcardpayload.setSecret_Key(secret_key);
virtualcardpayload.setTest(test);

String response = virtualCards.dovirtualcardget(virtualcardpayload);
```

Sample Code to terminate a virtual card.
```java
virtualCards virtualCards = new virtualCards();
virtualcardpayload virtualcardpayload = new virtualcardpayload():
virtualcardpayload.setId(id);
virtualcardpayload.setSecret_Key(secret_key);
virtualcardpayload.setTest(test);

String response = virtualCards.dovirtualcardterminate(virtualcardpayload);
```

Sample Code to fund a virtual card.
```java
virtualCards virtualCards = new virtualCards();
fundcardpayload fundcardpayload = new fundcardpayload():
fundcardpayload.setId(id);
fundcardpayload.setAmount(amount);
fundcardpayload.setDebit_currency(debit_currency);
fundcardpayload.setSecret_Key(secret_key);
fundcardpayload.setTest(test);

String response = virtualCards.dovirtualcardfund(fundcardpayload);
```

Sample Code to get a virtual card transaction.
```java
virtualCards virtualCards = new virtualCards();
fetchcardpayload fetchcardpayload = new fetchcardpayload():
fetchcardpayload.setId(id);
fetchcardpayload.setFromDate(FromDate);
fetchcardpayload.setToDate(ToDate);
fetchcardpayload.setPageIndex(PageIndex);
fetchcardpayload.setPageSize(pagesize);
fetchcardpayload.setCardId(cardid);
fetchcardpayload.setSecret_Key(secret_key);
fetchcardpayload.setTest(test);

String response = virtualCards.dovirtualcardfetchtrans(fetchcardpayload);
```

------
```java
virtualCards virtualCards = new virtualCards();
withdrawcardpayload withdrawcardpayload = new withdrawcardpayload():
withdrawcardpayload.setCard_id(card_id);
withdrawcardpayload.setAmount(amount);
withdrawcardpayload.setSecret_Key(secret_key);
withdrawcardpayload.setTest(test);

String response = virtualCards.dovirtualcardfwithdraw(withdrawcardpayload);
```

## Ebills

Sample Code to create Ebills

```java 
ebills ebills = new ebills();
ebillpayload ebillpayload = new ebillpayload();
ebillpayload.setAccountnumber(accountnumber);
ebillpayload.setNarration(narration);
ebillpayload.setNumberofunits(numberofunits);
ebillpayload.setCurrency(currency);
ebillpayload.setAmount(amount);
ebillpayload.setPhonenumber(phonenumber);
ebillpayload.setEmail(email);
ebillpayload.setTxRef(txref);
ebillpayload.setSeckey(SECKEY);
ebillpayload.setTest(test);

String response = ebills.doebillscreate(ebillpayload);
```

Sample Code to update Ebills
```java
ebills ebills = new ebills();
ebillpayload ebillpayload = new ebillpayload();
ebillpayload.setReference(reference);
ebillpayload.setCurrency(currency);
ebillpayload.setAmount(amount);
//ebillpayload.setSeckey(SECKEY);

String response = ebills.doebillsupdate(ebillpayload);
```

## Refund

Sample code to refund a transaction

```java
Refund refund = new Refund();
refundPayload refundpayload = new refundPayload();
refundpayload.setRef(ref);
refundpayload.setAmount(amount);
refundpayload.setSceretKey(seckey);
refundpayload.setTest(test);

String response = refund.dorefund(refundpayload);
```

## Tokenized Charge

Sample code for charging tokenised cards

```java
tokenCharge tokencharge = new tokenCharge();
tokenChargePayload tokenchargepayload = new tokenChargePayload();
tokenchargepayload.setCurrency(currency);
tokenchargepayload.setToken(token);
tokenchargepayload.setAmount(amount);
tokenchargepayload.setEmail(email);
tokenchargepayload.setFirstname(firstname);
tokenchargepayload.setLastname(Lastname);
tokenchargepayload.setTxRef(texref);
tokenchargepayload.setSECKEY(Seckey);
tokenchargepayload.setTest(test);

String response = tokencharge.dotokenizedcharge(tokenchargepayload);
```

Sample code to update email for a token

```java
tokenCharge tokencharge = new tokenCharge();
tokenChargePayload tokenchargepayload = new tokenChargePayload():
tokenchargepayload.setEmail(email);
tokenchargepayload.setToken(token);
tokenchargepayload.setSECKEY(Seckey);
tokenchargepayload.settest(test);
```

String response = tokencharge.dotokenizedcharge(tokenchargepayload);

## Payment plan
Sample code to create payment plan

```java
paymentplan paymentplan = new paymentplan();
pamentplancreatepayload pamentplancreatepayload = new pamentplancreatepayload();
pamentplancreatepayload.setSeckey(seckey);
pamentplancreatepayload.setamount(amount);
pamentplancreatepayload.setname(name);
pamentplancreatepayload.setinterval(interval);
pamentplancreatepayload.setduration(duration);
pamentplancreatepayload.settest(test);

String response = paymentplan.docreatepayment(pamentplancreatepayload);

```

Sample code to list payment plan
```java
paymentplan paymentplan = new paymentplan();
paymentplanfetch paymentplanfetch = new paymentplanfetch();
paymentplanfetch.setSeckey(seckey);
paymentplanfetch.setid(id);
paymentplanfetch.setq(q);
paymentplanfetch.settest(test);

String response = paymentplan.dopaymentplanlist(paymentplanfetch);

```

Sample code to cancel payment plan
```java
paymentplan paymentplan = new paymentplan();
paymentplanfetch paymentplanfetch = new paymentplanfetch();
paymentplanfetch.setid(id);
paymentplanfetch.setSeckey(seckey);
paymentplanfetch.settest(test);

String response = paymentplan.dopaymentplanlist(paymentplanfetch);

```

## Verify Transactions
Sample code to verify transactions

```java
transValidation transValidation = . new transValidation();
transverifyPayload transverifyPayload . = new transverifyPayload();
transverifyPayload.setSECKEY(sckey);
transverifyPayload.settxref(txref);
transverifyPayload.setTest(test);

String response = transValidation.bvnvalidate(transverifyPayload);
```
