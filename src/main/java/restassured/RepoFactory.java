package restassured;

public class RepoFactory {

    public String repoName;

    public RepoFactory(String repoName) {
        this.repoName = repoName;
    }

    public String getRepoName() {
        return repoName;
    }
}
