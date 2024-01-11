import time
from locust import HttpUser, between, task

"""
cmd =>  locust -f user.py

        https://petstore.swagger.io

        json format => Ctrl + Alt + L in windows
"""
class WebsiteUser(HttpUser):
    # yeni bir kullanıcıyı başlamadan önce min max arası rastgele bir süre bekle
    wait_time = between(5, 15)

    payload = {
        "id": 389654,
        "username": "qaLoad",
        "firstName": "loadNur",
        "lastName": "qaNur",
        "email": "nur999@gmail.com",
        "password": "12345",
        "phone": "12345678",
        "userStatus": 0
    }
    @task
    def userCreate(self):
        self.client.post("/v2/user", json=self.payload)

    @task
    def getUserInfo(self):
        time.sleep(1)
        self.client.get("/v2/user/{username}".format(username=self.payload.get("username")))

    @task
    def logout(self):
        self.client.get("/v2/user/logout")

    @task
    def login(self):
        self.client.get("/v2/user/login?username={username}&password={password}"
                        .format(username=self.payload.get("username"),password=self.payload.get("password")))

    @task
    def updateUser(self):
        updateBody = {
            "firstName": "aqLoadTest",
            "lastName": "test",
            "email": "test@qa.com",
            "phone": "23321321321",
        }
        self.payload.update(updateBody)# body guncellendi
        self.client.put("/v2/user/{username}".format(username=self.payload.get("username")), json=self.payload)

    @task
    def deleteUser(self):
        time.sleep(1)
        self.client.delete("/v2/user/{username}".format(username=self.payload.get("username")))

    payload2 = [
        {
            "id": 322224,
            "username": "qaLoad",
            "firstName": "loadNur",
            "lastName": "qaNur",
            "email": "nur999@gmail.com",
            "password": "12345",
            "phone": "12345678",
            "userStatus": 0
        },
        {
            "id": 322224,
            "username": "qaLoad",
            "firstName": "load888",
            "lastName": "qaNur",
            "email": "testqa999@gmail.com",
            "password": "12355555",
            "phone": "1234500008",
            "userStatus": 0
        }
    ]
    @task
    def createWithList(self):
        self.client.post("/v2/user/createWithList", json=self.payload2)

    @task
    def createWithArray(self):
        self.client.post("/v2/user/createWithArray", json=self.payload2)