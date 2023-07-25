package resources;
 public enum APIResources {
	
	getListUser("/users/"),
	getSingleUser("/users/"),
	getPosts("/users/"),
	getAlbums("/users/"); 
	
	
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
