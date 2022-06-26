Docker

1-Docker is a container management service
2-The whole idea of docker is to SHIP applications along with their environment into images which can be then run
anywhere
3- Docker Image :- In docker, image acts as set of instructions to build a container (class) 
4- Docker container :- It is running instance of image (object of class)

e.g. to run java application

jdk + application + OS =Image

provided-Docker in installed on that machine.

---------------------

How to create our own image?

we need to create a file called as = "Dockerfile"


---------------------------------------
There are commands to manage image and containers 

Commands for managing images 
1] docker image ls :-	This command shows all the images available locally 

2] docker pull <nameofimage> :- Download the image from docker hub 

3] docker container run <name> :-Use to run the docker image.

Dockerfile
#following command use to create our own image from dockerfile
4] Dockerfile--> (to convert into image)  "docker image build -t <imagename> ."  

#following command use to convert image into container
5] image ------> (to convert into container && to run docker image) "docker container run <nameofimage>"
container

To create image and push it to docker hub must follow following syntax while giving image name 
<dockurhubid>/<imagename>

example 
docker image build -t sarangkhangar/sarang .

docker image push <nameoftheimage> (use t uplaod the image to docker hub repo)

----------------------------------------------------------------------------------------------
If you are using AWS for docker with MobXterm then commands as follows :-
MobaXterm is SSH client we need this to connect to AWS virtual machine 
Use MobaXterm Application: MobaXterm is the SSH Client we need this to connect to AWS Virtual machine.

sudo yum install docker
docker --version
sudo service docker start
sudo chmod 777 /var/run/docker.sock














