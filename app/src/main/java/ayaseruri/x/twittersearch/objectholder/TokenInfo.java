package ayaseruri.x.twittersearch.objectholder;

/**
 * Created by ayaseruri on 15/12/22.
 */
public class TokenInfo {

    /**
     * token_type : bearer
     * access_token : AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA%2FAAAAAAAAAAAAAAAAAAAA%3DAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
     */

    private String token_type;
    private String access_token;

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public String getAccess_token() {
        return access_token;
    }
}
