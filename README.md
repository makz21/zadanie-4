# GET /search

Returns specific list of users from PŁ(https://adm.edu.p.lodz.pl/user/) in user friendly view format.<br>
There is a button under each user that allows you to download the vCard and lets you easily add a user to your contacts

# Resource URL

`http://localhost:8080/search?name={first_name}`<br>
`http://localhost:8080/search?name={last_name}`<br>
`http://localhost:8080/search?name={first_name}+{last_name}`<br>


## Resource Information

|                |                          	|                         
|----------------|-------------------------------|
|Response format|website with list of users           |
|Requires authentication?         |No            |
|Response format of download vCard button         |.vcs file            |



# Example Request

`GET localhost:8080/search?name=paweł+kapusta`

# Example Site Response for `/search?name=nowak`
<p align="center">
  <img src="https://i.imgur.com/r3ncv43.png" width="350" title="hover text">
</p>

# Example .vcs Response 

```

BEGIN:VCARD
VERSION:3.0
PRODID:ez-vcard 0.10.5
N:Kapusta;Paweł
FN;CHARSET=iso-8859-1:Paweł Kapusta
END:VCARD

```

