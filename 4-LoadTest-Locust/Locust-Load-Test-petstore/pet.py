import time,os
from locust import HttpUser, between, task

"""
cmd =>  locust -f pet.py

        https://petstore.swagger.io

        json format => Ctrl + Alt + L in windows
"""

class WebsiteUser(HttpUser):
    # yeni bir kullanıcıyı başlamadan önce min max arası rastgele bir süre bekle
    wait_time = between(5, 15)

    @task
    def petAdd(self):
        payload = {
            "id": 8,
            "category": {
                "id": 2,
                "name": "Dog"
            },
            "name": "doggie8",
            "photoUrls": [
                "string"
            ],
            "tags": [
                {
                    "id": 2,
                    "name": "kopek"
                }
            ],
            "status": "available"
        }
        self.client.post("/v2/pet", json=payload)

    @task
    def getFindById(self):
        self.client.get("/v2/pet/8")

    @task
    def getfindByStatus(self):
        self.client.get("/v2/pet/findByStatus?status=available")

    @task
    def petUpdate(self):
        payload = {
            "id": 8,
            "category": {
                "id": 2,
                "name": "Dog9"
            },
            "name": "doggie8",
            "photoUrls": [
                "string"
            ],
            "tags": [
                {
                    "id": 2,
                    "name": "kopeknameeklendi"
                }
            ],
            "status": "available"
        }
        self.client.put("/v2/pet", json=payload)

    def _get_image_part(self, file_path, file_content_type='image/jpeg'):
        file_name = os.path.basename(file_path)
        file_content = open(file_path, 'rb')
        return file_name, file_content, file_content_type

    @task
    def petUploadsImage(self):
        files = {
            "additionalMetadata": 'bu bir ek meta veridir',
            "file": self._get_image_part("./kurt.jpg")
        }
        self.client.post("/v2/pet/8/uploadImage", files=files)

    @task
    def UpdatesFormData(self):
        data = {
           "name=kedi&status=sold"
        }
        self.client.post("/v2/pet/8", data=data)

    @task
    def deletePet(self):
        time.sleep(3)
        self.client.delete("/v2/pet/8")

