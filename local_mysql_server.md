### :memo: <font color> How to install your local MySQL server </font>
#### (we'll be using containers for this)

1. Install Rancher Desktop from [HERE](https://rancherdesktop.io/)
Make sure to configure Rancher Desktop to use Docker cli
2. Run MySQL server as a container
The MySQL Official [repo](https://hub.docker.com/r/mysql/mysql-server) also presents instructions, but I prefer this command:
```
docker run --name=mysql --restart unless-stopped -p 3306:3306 -d mysql/mysql-server:5.7
```
3. Configure MySQL container to accept connections from any IP address
[This](https://stackoverflow.com/questions/33827342/how-to-connect-mysql-workbench-to-running-mysql-inside-docker) Stack Overflow article explains how to do it, but I will summarize the commands here for you:
```
#grab the default password from the container logs
docker logs mysql 2>&1 | grep GENERATED

#exec inside the container
docker exec -it mysql mysql -uroot -p

#if on fresh install, change password
ALTER USER 'root'@'localhost' IDENTIFIED BY 'new_password';

#check root user's connection permission
select host, user from mysql.user;

#if result looks like this:
+-----------+---------------+
| host      | user          |
+-----------+---------------+
| localhost | healthchecker |
| localhost | mysql.session |
| localhost | mysql.sys     |
| localhost | root          |
+-----------+---------------+
#you need to modify the root user to be able to connect from any host

#run command to change root's connection permissions:
update mysql.user set host = '%' where user='root';

#check root user's connection permission again
select host, user from mysql.user;

#should look like this:
+-----------+---------------+
| host      | user          |
+-----------+---------------+
| %         | root          |
| localhost | healthchecker |
| localhost | mysql.session |
| localhost | mysql.sys     |
+-----------+---------------+

#restart docker container
docker restart mysql
```
4. Connect to your local MySQL server using MySQL Workbench
5. Execute [this](https://github.com/razidare/path2DevOps_initial_setup/blob/main/product_table_query.sql) query in order to create the database&table