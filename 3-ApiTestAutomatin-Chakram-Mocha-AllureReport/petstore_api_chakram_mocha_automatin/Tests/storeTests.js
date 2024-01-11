const chakram = require('chakram'), expect = chakram.expect;

/*
Testleri calistir cmd => node runner.js
Rapor olustur => npx allure serve allure-results

Format document (VSC) in windows => Alt + Shift +F 
*/

describe("Store Module", function () {

  const storeBaseUrl = "https://petstore.swagger.io/v2/store";

  const body = {
    "id": 3,
    "petId": 555,
    "quantity": 2,
    "shipDate": "2023-12-28T10:53:47.511Z",
    "status": "placed",
    "complete": true
  }

  it("POST - CreateOrder", function () {
    const resBody = {
      "id": 3,
      "petId": 555,
      "quantity": 2,
      "status": "placed",
      "complete": true
    }
    const response = chakram.post(storeBaseUrl.concat("/order"), body);

    expect(response).to.have.status(200);
    expect(response).to.comprise.of.json(resBody);
    expect(response).to.have.header('content-type', 'application/json');
    return chakram.wait();
  });


  it("GET - StoreGetOrderID", function () {
    const resBody = {
      "id": 3,
      "petId": 555,
      "quantity": 2,
      "status": "placed",
      "complete": true
    }
    const response = chakram.get(storeBaseUrl.concat("/order/", body.id.toString()));

    expect(response).to.have.status(200);
    expect(response).to.comprise.of.json(resBody);
    expect(response).to.have.header('content-type', 'application/json');
    return chakram.wait();
  });


  it("DELETE - DeleteOrder", function () {
    const resBody = {
      "code": 200,
      "type": "unknown",
      "message": body.id.toString()
    }
    const response = chakram.delete(storeBaseUrl.concat("/order/", body.id.toString()));

    expect(response).to.have.status(200);
    expect(response).to.comprise.of.json(resBody);
    expect(response).to.have.header('content-type', 'application/json');
    return chakram.wait();
  });

  it("GET - GetInventory", function () {
    const response = chakram.get(storeBaseUrl.concat("/inventory"));

    expect(response).to.have.status(200);
    expect(response).to.have.header('content-type', 'application/json');
    return chakram.wait();
  });

});