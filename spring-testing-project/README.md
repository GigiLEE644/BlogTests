curl -X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{"name":"john","email":"john@mail.com"}'

curl http://localhost:8080/users/1

curl -u user:50c7e185-fc1e-478e-b8ad-590b19677912 \
-X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{"name":"john","email":"john@mail.com"}'

curl -u user:39dde4b7-7bda-4e45-bfed-e4b0bd6ec2d3 http://localhost:8080/users/1
