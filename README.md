# Mike's sandbox

Project demonstrating an issue I'm having with serializing self-referencing Spring Data entities in a category hierarchy.

To reproduce:

* 1. Download source code
* 2. Run: mvn compile test
* 3. Two tests should produce the same error
 
The expect result from the Store REST repository test (StoreRepositoryIT.restGetStoreProductsEmbedded) is a Store object with embedded ProductCategory objects in its categories relationship. The ProductCategory objects should also embed their children ProductCategory objects in their children relationship. As is, the following error is produced:

restGetStoreProductsEmbedded(com.synthapp.embeddedproject.repo.StoreRepositoryTest): Request processing failed; nested exception is org.springframework.http.converter.HttpMessageNotWritableException: Could not write content: Infinite recursion (StackOverflowError) (through reference chain: org.springframework.hateoas.PagedResources["_embedded"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: Infinite recursion (StackOverflowError) (through reference chain: org.springframework.hateoas.PagedResources["_embedded"])

An attmept to remove the bi-drectioanl relationships was also made that produces the same error. Store/Product entities, tests, and repos were created with NotBiDirectional appended to their names. Like with the bi-directional relationship versions  the entities have no problems reading from the database, but they fail to serialize the desired JSON representation without error. 
