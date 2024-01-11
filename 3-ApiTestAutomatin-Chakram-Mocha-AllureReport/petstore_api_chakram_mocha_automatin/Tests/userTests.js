const chakram = require('chakram'), expect = chakram.expect;
/*
Testleri calistir cmd => node runner.js
Rapor olustur => npx allure serve allure-results

chakram test => npm test

Format document (VSC) in windows => Alt + Shift +F 
*/

describe("User Module", function () {

  const userBaseUrl = "https://petstore.swagger.io/v2/user";

  it("POST - CreateUser", function () {
    const resBody = { "code": 200, "type": "unknown", "message": "36" };
    const body = {
      "id": 36,
      "username": "qa-nur",
      "firstName": "qa firstname",
      "lastName": "qa lastname",
      "email": "qa-email@testemail.com",
      "password": "qa_password",
      "phone": "9876543210",
      "userStatus": 1
    };
    const response = chakram.post(userBaseUrl, body);
    expect(response).to.have.status(200);
    expect(response).to.comprise.of.json(resBody);
    expect(response).to.have.header('content-type', 'application/json');
    return chakram.wait();
  });
  const body2 = [
    {
      "id": 44,
      "username": "Test username",
      "firstName": "Test firstname",
      "lastName": "Test lastname",
      "email": "test@email.com",
      "password": "test password",
      "phone": "0123456789",
      "userStatus": 1
    },
    {
      "id": 45,
      "username": "Test2 username",
      "firstName": "Test2 firstname",
      "lastName": "Test2 lastname",
      "email": "test2@email.com",
      "password": "test2 password",
      "phone": "2-0123456789",
      "userStatus": 0
    }
  ];

  it("POST - CreateUserWithArray", function () {
    const resBody = { "code": 200, "type": "unknown", "message": "ok" };
    const response = chakram.post(userBaseUrl.concat("/createWithArray"), body2);
    
    expect(response).to.have.status(200);
    expect(response).to.comprise.of.json(resBody);
    expect(response).to.have.header('content-type', 'application/json');
    return chakram.wait();
  });

  it("POST - CreateUserWithList", function () {
    const resBody = { "code": 200, "type": "unknown", "message": "ok" };
    const response = chakram.post(userBaseUrl.concat("/createWithList"), body2);

    expect(response).to.have.status(200);
    expect(response).to.comprise.of.json(resBody);
    expect(response).to.have.header('content-type', 'application/json');
    return chakram.wait();
  });

  it("GET - GetUser", function () {
    const resBody = body2[0];
    const response = chakram.get(userBaseUrl.concat("/Test%20username"));

    expect(response).to.have.status(200);
    expect(response).to.comprise.of.json(resBody);
    expect(response).to.have.header('content-type', 'application/json'); // content-type formatının ne olması gerek
    return chakram.wait();
  });

  it("PUT - UpdateUser", function () {
    const body = {
      "id": 44,
      "username": "Testusername",
      "firstName": "Test firstname",
      "lastName": "Test lastname",
      "email": "testyeni@email.com",
      "password": "TestPassword",
      "phone": "string",
      "userStatus": 0
    }
    const resBody = {
      "code": 200,
      "type": "unknown",
      "message": body.id.toString()
    }
    const response = chakram.put(userBaseUrl.concat("/Testusername"), body);
    expect(response).to.have.status(200);
    expect(response).to.comprise.of.json(resBody);
    expect(response).to.have.header('content-type', 'application/json');
    return chakram.wait();
  });

  it("GET - UserLogin", function () {
    const username = "Testusername";
    const password = "TestPassword";
    return chakram.get(userBaseUrl.concat("/login?username=", username, "&password=", password))
      .then(function (response) {
        const resBody = {
          "code": 200,
          "type": "unknown"
        }
        expect(response).to.have.status(200);
        expect(response).to.comprise.of.json(resBody);
        expect(response).to.have.header('content-type', 'application/json');
        return chakram.wait();
      });
  });

  it("GET - UserLogout", function () {
    const resBody = {
      "code": 200,
      "type": "unknown",
      "message": "ok"
    }
    const response = chakram.get(userBaseUrl.concat("/logout"));
    
    expect(response).to.have.status(200);
    expect(response).to.comprise.of.json(resBody);
    return chakram.wait();
  });

  it("DELETE - DeleteUser", function () {
    const resBody = {
      "code": 200,
      "type": "unknown",
      "message": "Testusername"
    }
    const response = chakram.delete(userBaseUrl.concat("/Testusername"));
   
    expect(response).to.have.status(200);
    expect(response).to.comprise.of.json(resBody);
    expect(response).to.have.header('content-type', 'application/json');
    return chakram.wait();
  });

});