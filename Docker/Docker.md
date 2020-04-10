# Docker

A container can be thought as a completely self-contained machine, for all intents and purposes it has its own OS, its own file system and anything else you would expect to find in a virtualised machine. But the catch is that a container only runs one program. A container can actually run more than one process. However you probably wouldn’t do this unless you had a special reason to. In almost all cases it’s best to run one process or service in a single container.
Docker works by using linux kernel features and creating containers to be used by application.

It uses Linux Kernel features like _**namespaces**_ and _**control groups**_ to create containers on top of an operating system.

Docker uses Union File Systems to build up an image. You can think of a Union File System as a stackable file system, meaning files and directories of separate file systems (known as branches) can be transparently overlaid to form a single file system.

Resources like _**[THIS](https://www.freecodecamp.org/news/a-beginner-friendly-introduction-to-containers-vms-and-docker-79a9e3e119b/)**_ for everything or [this](https://www.freecodecamp.org/news/docker-simplified-96639a35ff36/) for types and architecture of docker.

# Docker concepts

## DockerFile
A Dockerfile is where you write the instructions to build a Docker image. Once you’ve got your Dockerfile set up, you can use the docker build command to build an image from it.

## DockerClient
The Docker Client is what you, as the end-user of Docker, communicate with. Think of it as the UI for Docker, you are communicating to the _**Docker Client, which then communicates your instructions to the Docker Daemon.**_

## DockerDaemon
The Docker daemon is what actually executes commands sent to the Docker Client — like building, running, and distributing your containers. The Docker Daemon runs on the host machine, but as a user, you never communicate directly with the Daemon.

## Docker Image
In layman terms, Docker Image can be compared to a template which is used to create Docker Containers. So, these read-only templates are the building blocks of a Docker Container. You can use docker run to run the image and create a container.

## Docker Container
Docker Container is a running instance of a Docker Image as they hold the entire package needed to run the application. So, these are basically the ready applications created from Docker Images which is the ultimate utility of Docker.

## Docker Volumes
Volumes are the “data” part of a container, initialized when a container is created. Volumes allow you to persist and share a container’s data. Data volumes are separate from the default Union File System and exist as normal directories and files on the host filesystem. So, even if you destroy, update, or rebuild your container, the data volumes will remain untouched. When you want to update a volume, you make changes to it directly. (As an added bonus, data volumes can be shared and reused among multiple containers, which is pretty neat.)

Docker CLI commands(Ubuntu):
Daemon :
- Starting docker daemon
    - sudo systemctl start docker
    - sudo systemctl enable docker
    - sudo service docker start
- Status
    - sudo systemctl is-active docker
    - (or) systemctl status docker
    - (or) sudo status docker
    - (or) sudo service docker status
  
[DockerCommands](https://www.docker.com/sites/default/files/d8/2019-09/docker-cheat-sheet.pdf) cheat sheet

[Ultimate guide](https://hackernoon.com/docker-commands-the-ultimate-cheat-sheet-994ac78e2888)
