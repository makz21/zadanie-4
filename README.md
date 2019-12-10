# GET /search

Returns list of users from PŁ(https://adm.edu.p.lodz.pl/user/) in user friendly view format.

# Resource URL

`http://localhost:8080/search?name={first_name}`
`http://localhost:8080/search?name={last_name}`
`http://localhost:8080/search?name={first_name}+{last_name}`


## Resource Information

|                |                          	|                         
|----------------|-------------------------------|
|Response formats|`vcf` file           |
|Requires authentication?         |No            |


# Example Request

`GET localhost:8080/search?name=paweł+kapusta`

# Example .vcs Response 

```

BEGIN:VCARD
VERSION:3.0
PRODID:ez-vcard 0.10.5
N:Kapusta;Paweł
FN;CHARSET=iso-8859-1:Paweł Kapusta
END:VCARD

```

