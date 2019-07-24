
# Devops Commands

# Docker

List of images:
`$ docker images`

In your Dockerfile:
 EXPOSE 3000 80 443 22
 

To expose just one port, this is what you need to do:
`$ docker run -p <host_port>:<container_port>`

To expose multiple ports, simply provide multiple -p arguments:
`$ docker run -p <host_port1>:<container_port1> -p <host_port2>:<container_port2>`

In case you would like to expose a range of continuous ports, you can run docker like this:
 `docker run -it -p 7100-7120:7100-7120/tcp `

Eg.
 `$ docker run -p 3001:3000 -p 23:22`

List running docker process:
`$ docker ps`

>Important URL - 
 - [https://stackoverflow.com/questions/34004076/difference-between-docker-registry-and-repository](https://link) 
 - [https://stackoverflow.com/questions/23735149/what-is-the-difference-between-a-docker-image-and-a-container](https://link)
 - [https://stackoverflow.com/questions/31115098/in-docker-what-is-the-difference-between-an-image-and-a-repository](https://link)
 
 
 


#  Kubernates

Deploying the Dashboard UI

`kubectl create -f https://raw.githubusercontent.com/kubernetes/dashboard/master/aio/deploy/recommended/kubernetes-dashboard.yaml`
 
For open Dashboard
`$minikube dashboard` 

For accessing the Dashboard
`$kubectl proxy`

 >Running Kubernetes Locally via Minikube

Starting the app:

`$ minikube start`

Running sample app:

`$ kubectl run hello-minikube --image=k8s.gcr.io/echoserver:1.10 --port=8080`

View the Deployment:
`$ kubectl get deployments`

Exposing the app:
`$ kubectl expose deployment hello-minikube --type=NodePort`

Get the pod list:
`$ kubectl get pods`

View the Service:
`$ kubectl get services`

View service with pritty view:
`$ kubectl get services -o json`

View cluster events:
`$ kubectl get events`

View the kubectl configuration:
`$ kubectl config view`

Get the sample app url by curl:
`$ curl $(minikube service hello-minikube --url)`

>Stopping a Cluster:

`$ minikube stop`

Deleting a Cluster:
`$ minikube delete`
eg. `$ kubectl delete services hello-minikube`
eg. `$ kubectl delete deployment hello-minikube`
eg. `$ minikube stop`

Delete minikube data:
`rm -rf  ~/.minikube`

>Enable addons

List the currently supported addons:
`$ minikube addons list`

Enable an addon, for example, heapster:
`$ minikube addons enable heapster`

View the Pod and Service you just created:
`$ kubectl get pod,svc -n kube-system`

Disable heapster:
`$ minikube addons disable heapster`

Add namespace:
`$ kubectl create namespace istio-system`

Get crds:
`$ kubectl get crd`

>Clean up

Now you can clean up the resources you created in your cluster:
`$ kubectl delete service hello-node`
`$ kubectl delete deployment hello-node`

>Creating sample user

Copy provided snippets to some dashboard-adminuser.yaml file and use kubectl apply -f dashboard-adminuser.yaml to create them.

`apiVersion: v1
kind: ServiceAccount
metadata:
  name: admin-user
  namespace: kube-system`
  
  >Bearer Token
  
  `kubectl -n kube-system describe secret $(kubectl -n kube-system get secret | grep admin-user | awk '{print $1}')`
  
  >Rabbit MQ
  
  https://hub.docker.com/_/rabbitmq/
  
 docker run --name pankoo-rabbit -p 8080:15672 rabbitmq:3-management

 # Mongo Db commands:

# Important linux command

For finding file in folder 

`$ find | grep <any file name>` 
  