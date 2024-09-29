first commit,,

# mongoDb installation
https://www.mongodb.com/docs/manual/tutorial/install-mongodb-community-with-docker/
docker pull mongodb/mongodb-community-server:latest
docker run --name mongodb -p 27017:27017 -d mongodb/mongodb-community-server:latest

**Set Up Environment Variables**
Create a .env file in the root directory and add the following environment variables:
   ```bash
    DATABASE_URL=mysql_url
    DATABASE_USERNAME=your_db_user
    DATABASE_PASSWORD=your_db_password
    MONGODB_URL=mongodb_url
   ```