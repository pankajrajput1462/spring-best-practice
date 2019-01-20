
## Step 4  Use Curl or Postman to test the REST apis created. 
UserController has api using ElasticsearchTemplate
UserRepositoryController has api using ElasticsearchRepository

## APIs for ElastisearchTemplate usage
1. POST call for creating new User-
http://localhost:8102/repo/new

### JSON data
```
{
  "name": "Sumit",
   "userSettings": {
   	"gender" : "male",
   	"occupation" : "CA",
   	"hobby" : "chess"
   }
}
```

2. GET call for Retrieve all Users
http://localhost:8102/all

3. Add User setting entry by name
http://localhost:8102/settings/Pankaj/hobby/poetry

For other apis, check code.

## APIs for ElasticsearchRepository usage

1. POST call for creating new User-
http://localhost:8102/repo/new
### JSON Data
```
{
  "name": "Pankaj",
   "userSettings": {
   	"gender" : "Male",
   	"occupation" : "Software Engineer",
   	"hobby" : "racing"
   }
}
```

2. GET call for Retrieve all Users -
http://localhost:8102/repo/all


3. Add User settings entry by for a userId -
http://localhost:8102/repo/settings/AWdeQyaoTJbZRlQtLZfL/hobby/chess

For other apis, check code.







