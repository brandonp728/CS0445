package cs445.a1;

public class Profile implements ProfileInterface {
	private String name, about;
	private Set<ProfileInterface> pplFollowing;
	
	public Profile()
	{
		name="";
		about="";
		pplFollowing=new Set<ProfileInterface>();
	}
	
	public Profile(String n, String a)
	{
		name = n;
		about = a;
		pplFollowing=new Set<ProfileInterface>();
	}
	
	@Override
	public void setName(String newName) throws IllegalArgumentException {
		if(newName==null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			name = newName;
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setAbout(String newAbout) throws IllegalArgumentException {
		if(newAbout == null)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			about=newAbout;
		}
	}

	@Override
	public String getAbout() {
		return about;
	}

	public boolean follow(ProfileInterface other) {
		boolean allGood=false;
		if(other==null)
		{
			allGood=false;
		}
		else
		{
			try
			{
				allGood=pplFollowing.add(other);
			}
			catch(Exception e){}
		}
		return allGood;
		
	}
	public boolean unfollow(ProfileInterface other) {
		boolean allGood=false;
		if(!pplFollowing.contains(other) || other==null)
		{
			allGood=false;
		}
		else
		{
			try
			{
				allGood=pplFollowing.remove(other);
			}
			catch (Exception e){}
		}
		return allGood;
	}

	@Override
	public ProfileInterface[] following(int howMany) {
		Object[] tempArry = pplFollowing.toArray();
		ProfileInterface[] profiles;
		if(howMany<tempArry.length)
		{
			profiles = new ProfileInterface[howMany];
		}
		else
		{
			profiles = new ProfileInterface[tempArry.length];
		}
		for(int i=0; i<tempArry.length; i++)
		{
				profiles[i] = (ProfileInterface) tempArry[i];
		}
		
		return profiles;
	}

	@Override
	public ProfileInterface recommend() {
		boolean alreadyFriends=false;
		Object[] followingArry = pplFollowing.toArray();
		Profile temp; 
		ProfileInterface recommendedPerson=null;
		ProfileInterface[] otherPerson;
		for(int i=0; i<followingArry.length; i++)
		{
			temp =(Profile) followingArry[i];
			otherPerson = temp.following(100);
			for(int j=0; j<otherPerson.length; j++)
			{
				if(otherPerson[j].getName()!=this.getName() && !pplFollowing.contains(otherPerson[j]))
				{
					recommendedPerson = otherPerson[j];
					break;
				}
			}
		}
		return recommendedPerson;
	}

}
