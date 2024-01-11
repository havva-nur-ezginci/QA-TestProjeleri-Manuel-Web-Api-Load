import time
from locust import HttpUser, between, task
"""
cmd =>  locust -f store.py
    
        https://petstore.swagger.io
    
        json format => Ctrl + Alt + L in windows
"""
class WebsiteUser(HttpUser):
    # yeni bir kullanıcıyı başlamadan önce min max arası rastgele bir süre bekle
    wait_time = between(5, 10)
    payload = {
        "id": 8,
        "petId": 9,
        "quantity": 278,
        "shipDate": "2024-01-09T11:26:07.834Z",
        "status": "placed",
        "complete": True
    }

    @task
    def createOrder(self):
        self.client.post("/v2/store/order", json=self.payload)

    @task
    def getOrderById(self):
        time.sleep(2)
        self.client.get("/v2/store/order/{id}".format(id=self.payload.get("id")))

    @task
    def getInventory(self):
        self.client.get("/v2/store/inventory")

    @task
    def deleteOrder(self):
        time.sleep(3)
        self.client.delete("/v2/store/order/{id}".format(id=self.payload.get("id")))

