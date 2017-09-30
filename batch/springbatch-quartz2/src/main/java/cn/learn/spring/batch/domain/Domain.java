package cn.learn.spring.batch.domain;

public class Domain {
	private String id;
	private String domain;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		return "id: " + id + ", domain: " + domain;
	}

}
