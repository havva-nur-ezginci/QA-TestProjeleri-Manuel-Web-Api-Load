const chakram = require('chakram'), expect = chakram.expect, fs = require('fs'), path = require("path");
/*
Testleri çalıştır cmd => node runner.js
Rapor oluştur => npx allure serve allure-results

Format document (VSC) in windows => Alt + Shift +F 
*/

describe("Pet Module", function () {

  const petBaseUrl = "https://petstore.swagger.io/v2/pet";
  const body = {
    "id": 829,
    "category": {
      "id": 3,
      "name": "string"
    },
    "name": "Kurt",
    "photoUrls": [
      "string"
    ],
    "tags": [
      {
        "id": 0,
        "name": "deneme"
      }
    ],
    "status": "sold"
  }


  it("POST - CreatePet", () => {
    const resBody = body;
    const response = chakram.post(petBaseUrl, body);

    expect(response).to.have.status(200);
    expect(response).to.comprise.of.json(resBody);
    expect(response).to.have.header('content-type', 'application/json');
    return chakram.wait();
  });

  it("GET - GetPetById", function () {
    const resBody = body;
    const response = chakram.get(petBaseUrl.concat("/", body.id.toString()));

    expect(response).to.have.status(200);
    expect(response).to.comprise.of.json(resBody);
    expect(response).to.have.header('content-type', 'application/json');
    return chakram.wait();
  });


  it("GET - GetFindByStatus", function () {
    const status = ["available", "pending", "sold"];

    return chakram.get(petBaseUrl.concat("/findByStatus?status=", status[0]))
      .then(function (response) {

        expect(response).to.have.status(200);
        expect(response).to.have.header('content-type', 'application/json');
        chakram.wait();
      });

  });

  //postman de bu test yapilacaksa resim manuel olarak eklenmelidir.
  it("POST - UploadImage", function () {
    const resBody = {
      "code": 200,
      "type": "unknown",
      "message": "additionalMetadata: Bu bir form data body denemesidir.\nFile uploaded to ./kurt.jpg, 90463 bytes"
    }

    var file = path.resolve('./Tests/', 'kurt.jpg');
    const config = {
      'formData': {
        'additionalMetadata': 'Bu bir form data body denemesidir.',
        'file': fs.createReadStream(file)
      }
    }
    const response = chakram.post(petBaseUrl.concat("/", body.id.toString(), "/uploadImage"),
      undefined, config);

    expect(response).to.have.status(200);
    expect(response).to.comprise.of.json(resBody);
    expect(response).to.have.header('content-type', 'application/json');
    return chakram.wait();
  });


  it("PUT - UpdatePet", function () {

    body.name = "Name put update ile değiştirildi";
    body.status = "available";

    const resBody = body;
    const response = chakram.put(petBaseUrl, body);

    expect(response).to.have.status(200);
    expect(response).to.comprise.of.json(resBody);
    expect(response).to.have.header('content-type', 'application/json');
    return chakram.wait();
  });

  it("POST - UpdateFormData", function () {
    const resBody = {
      "code": 200,
      "type": "unknown",
      "message": body.id.toString()
    }

    var config = {//'x-www-form-urlencoded': 
      'x-www-form-urlencoded': {
        'name': 'name post updateform ile değiştirildi.',
        'status': 'pending'
      }
    }
    const response = chakram.post(petBaseUrl.concat("/", body.id.toString()), undefined, config);

    expect(response).to.have.status(200);
    expect(response).to.comprise.of.json(resBody);
    expect(response).to.have.header('content-type', 'application/json');
    return chakram.wait();
  });


  it("DELETE - DeletePet", function () {
    const resBody = {
      "code": 200,
      "type": "unknown",
      "message": body.id.toString()
    }
    const response = chakram.delete(petBaseUrl.concat("/", body.id.toString()));
    expect(response).to.have.status(200);
    expect(response).to.comprise.of.json(resBody);
    expect(response).to.have.header('content-type', 'application/json');
    return chakram.wait();
  });

});
