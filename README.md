# Mike's sandbox

Project demonstrating an issue I'm having with serializing self-referencing Spring Data entities.

To reproduce:

* 1. Download source code
* 2. Run: mvn install test
* 3. One test should fail
 
The expect result from the Store REST repository test (StoreRepositoryIT.restGetStoreProductsEmbedded) is an Store object with embedded ProductCategory objects in its values relationship. The ProductCategory objects should also embed their children ProductCategory objects in the children relationship. As is the following error is produced:

restGetStoreProductsEmbedded(com.synthapp.embeddedproject.com.repo.StoreRepositoryIT): Request processing failed; nested exception is org.springframework.http.converter.HttpMessageNotWritableException: Could not write content: Infinite recursion (StackOverflowError) (through reference chain: org.springframework.hateoas.PagedResources["_embedded"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: Infinite recursion (StackOverflowError) (through reference chain: org.springframework.hateoas.PagedResources["_embedded"])
