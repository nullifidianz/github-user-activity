package com.githubuseractivity.github;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GitHubApiClientTest {
    @Test
    public void testGetUserEvents() {
        GitHubApiClient client = new GitHubApiClient();
        assertNull(client.getUserEvents("usuario-exemplo"));
    }
}