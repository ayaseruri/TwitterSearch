package ayaseruri.x.twittersearch.objectholder;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ayaseruri on 15/12/22.
 */
public class SearchResultInfo {

    /**
     * completed_in : 0.061
     * max_id : 679254185569861633
     * max_id_str : 679254185569861633
     * next_results : ?max_id=679254151541428223&q=jack&include_entities=1
     * query : jack
     * refresh_url : ?since_id=679254185569861633&q=jack&include_entities=1
     * count : 15
     * since_id : 0
     * since_id_str : 0
     */

    private SearchMetadataEntity search_metadata;
    /**
     * metadata : {"iso_language_code":"pt","result_type":"recent"}
     * created_at : Tue Dec 22 10:56:32 +0000 2015
     * id : 679254185569861633
     * id_str : 679254185569861633
     * text : RT @QueridoJeito: Não demonstrar, não significa não sentir.
     * source : <a href="http://twitter.com/download/android" rel="nofollow">Twitter for Android</a>
     * truncated : false
     * in_reply_to_status_id : null
     * in_reply_to_status_id_str : null
     * in_reply_to_user_id : null
     * in_reply_to_user_id_str : null
     * in_reply_to_screen_name : null
     * user : {"id":3302823982,"id_str":"3302823982","name":"Jacks","screen_name":"Jack_8906","location":"","description":"Entregue seu caminho ao senhor, confie nele e ele agirá","url":null,"entities":{"description":{"urls":[]}},"protected":false,"followers_count":165,"friends_count":354,"listed_count":0,"created_at":"Fri May 29 13:05:31 +0000 2015","favourites_count":429,"utc_offset":null,"time_zone":null,"geo_enabled":false,"verified":false,"statuses_count":4605,"lang":"pt","contributors_enabled":false,"is_translator":false,"is_translation_enabled":false,"profile_background_color":"C0DEED","profile_background_image_url":"http://abs.twimg.com/images/themes/theme1/bg.png","profile_background_image_url_https":"https://abs.twimg.com/images/themes/theme1/bg.png","profile_background_tile":false,"profile_image_url":"http://pbs.twimg.com/profile_images/678997568278421504/Ukx-syWJ_normal.jpg","profile_image_url_https":"https://pbs.twimg.com/profile_images/678997568278421504/Ukx-syWJ_normal.jpg","profile_banner_url":"https://pbs.twimg.com/profile_banners/3302823982/1450720817","profile_link_color":"0084B4","profile_sidebar_border_color":"C0DEED","profile_sidebar_fill_color":"DDEEF6","profile_text_color":"333333","profile_use_background_image":true,"has_extended_profile":false,"default_profile":true,"default_profile_image":false,"following":false,"follow_request_sent":false,"notifications":false}
     * geo : null
     * coordinates : null
     * place : null
     * contributors : null
     * retweeted_status : {"metadata":{"iso_language_code":"pt","result_type":"recent"},"created_at":"Tue Dec 22 10:45:19 +0000 2015","id":679251361263915008,"id_str":"679251361263915008","text":"Não demonstrar, não significa não sentir.","source":"<a href=\"http://www.hootsuite.com\" rel=\"nofollow\">Hootsuite<\/a>","truncated":false,"in_reply_to_status_id":null,"in_reply_to_status_id_str":null,"in_reply_to_user_id":null,"in_reply_to_user_id_str":null,"in_reply_to_screen_name":null,"user":{"id":369645502,"id_str":"369645502","name":"Querido Jeito س","screen_name":"QueridoJeito","location":"","description":"Frases, pensamentos e sentimentos. Trechos de séries, filmes e músicas.\nContato:  queridojeito@gmail.com","url":"https://t.co/FY2IoJbU0O","entities":{"url":{"urls":[{"url":"https://t.co/FY2IoJbU0O","expanded_url":"https://instagram.com/queridojeito","display_url":"instagram.com/queridojeito","indices":[0,23]}]},"description":{"urls":[]}},"protected":false,"followers_count":955765,"friends_count":664236,"listed_count":327,"created_at":"Wed Sep 07 18:11:37 +0000 2011","favourites_count":5110,"utc_offset":-7200,"time_zone":"Brasilia","geo_enabled":false,"verified":false,"statuses_count":24819,"lang":"pt","contributors_enabled":false,"is_translator":false,"is_translation_enabled":false,"profile_background_color":"131516","profile_background_image_url":"http://pbs.twimg.com/profile_background_images/441050703625064448/JDU_IICQ.jpeg","profile_background_image_url_https":"https://pbs.twimg.com/profile_background_images/441050703625064448/JDU_IICQ.jpeg","profile_background_tile":true,"profile_image_url":"http://pbs.twimg.com/profile_images/665344116453187584/pAhf2S6O_normal.jpg","profile_image_url_https":"https://pbs.twimg.com/profile_images/665344116453187584/pAhf2S6O_normal.jpg","profile_banner_url":"https://pbs.twimg.com/profile_banners/369645502/1450228771","profile_link_color":"131516","profile_sidebar_border_color":"000000","profile_sidebar_fill_color":"EFEFEF","profile_text_color":"333333","profile_use_background_image":true,"has_extended_profile":false,"default_profile":false,"default_profile_image":false,"following":false,"follow_request_sent":false,"notifications":false},"geo":null,"coordinates":null,"place":null,"contributors":null,"is_quote_status":false,"retweet_count":56,"favorite_count":48,"entities":{"hashtags":[],"symbols":[],"user_mentions":[],"urls":[]},"favorited":false,"retweeted":false,"lang":"pt"}
     * is_quote_status : false
     * retweet_count : 56
     * favorite_count : 0
     * entities : {"hashtags":[],"symbols":[],"user_mentions":[{"screen_name":"QueridoJeito","name":"Querido Jeito س","id":369645502,"id_str":"369645502","indices":[3,16]}],"urls":[]}
     * favorited : false
     * retweeted : false
     * lang : pt
     */

    private List<StatusesEntity> statuses;

    public void setSearch_metadata(SearchMetadataEntity search_metadata) {
        this.search_metadata = search_metadata;
    }

    public void setStatuses(List<StatusesEntity> statuses) {
        this.statuses = statuses;
    }

    public SearchMetadataEntity getSearch_metadata() {
        return search_metadata;
    }

    public List<StatusesEntity> getStatuses() {
        return statuses;
    }

    public static class SearchMetadataEntity {
        private double completed_in;
        private long max_id;
        private String max_id_str;
        private String next_results;
        private String query;
        private String refresh_url;
        private int count;
        private int since_id;
        private String since_id_str;

        public void setCompleted_in(double completed_in) {
            this.completed_in = completed_in;
        }

        public void setMax_id(long max_id) {
            this.max_id = max_id;
        }

        public void setMax_id_str(String max_id_str) {
            this.max_id_str = max_id_str;
        }

        public void setNext_results(String next_results) {
            this.next_results = next_results;
        }

        public void setQuery(String query) {
            this.query = query;
        }

        public void setRefresh_url(String refresh_url) {
            this.refresh_url = refresh_url;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setSince_id(int since_id) {
            this.since_id = since_id;
        }

        public void setSince_id_str(String since_id_str) {
            this.since_id_str = since_id_str;
        }

        public double getCompleted_in() {
            return completed_in;
        }

        public long getMax_id() {
            return max_id;
        }

        public String getMax_id_str() {
            return max_id_str;
        }

        public String getNext_results() {
            return next_results;
        }

        public String getQuery() {
            return query;
        }

        public String getRefresh_url() {
            return refresh_url;
        }

        public int getCount() {
            return count;
        }

        public int getSince_id() {
            return since_id;
        }

        public String getSince_id_str() {
            return since_id_str;
        }
    }

    public static class StatusesEntity {
        /**
         * iso_language_code : pt
         * result_type : recent
         */

        private MetadataEntity metadata;
        private String created_at;
        private long id;
        private String id_str;
        private String text;
        private String source;
        private boolean truncated;
        private Object in_reply_to_status_id;
        private Object in_reply_to_status_id_str;
        private Object in_reply_to_user_id;
        private Object in_reply_to_user_id_str;
        private Object in_reply_to_screen_name;
        /**
         * id : 3302823982
         * id_str : 3302823982
         * name : Jacks
         * screen_name : Jack_8906
         * location :
         * description : Entregue seu caminho ao senhor, confie nele e ele agirá
         * url : null
         * entities : {"description":{"urls":[]}}
         * protected : false
         * followers_count : 165
         * friends_count : 354
         * listed_count : 0
         * created_at : Fri May 29 13:05:31 +0000 2015
         * favourites_count : 429
         * utc_offset : null
         * time_zone : null
         * geo_enabled : false
         * verified : false
         * statuses_count : 4605
         * lang : pt
         * contributors_enabled : false
         * is_translator : false
         * is_translation_enabled : false
         * profile_background_color : C0DEED
         * profile_background_image_url : http://abs.twimg.com/images/themes/theme1/bg.png
         * profile_background_image_url_https : https://abs.twimg.com/images/themes/theme1/bg.png
         * profile_background_tile : false
         * profile_image_url : http://pbs.twimg.com/profile_images/678997568278421504/Ukx-syWJ_normal.jpg
         * profile_image_url_https : https://pbs.twimg.com/profile_images/678997568278421504/Ukx-syWJ_normal.jpg
         * profile_banner_url : https://pbs.twimg.com/profile_banners/3302823982/1450720817
         * profile_link_color : 0084B4
         * profile_sidebar_border_color : C0DEED
         * profile_sidebar_fill_color : DDEEF6
         * profile_text_color : 333333
         * profile_use_background_image : true
         * has_extended_profile : false
         * default_profile : true
         * default_profile_image : false
         * following : false
         * follow_request_sent : false
         * notifications : false
         */

        private UserEntity user;
        private Object geo;
        private Object coordinates;
        private Object place;
        private Object contributors;
        /**
         * metadata : {"iso_language_code":"pt","result_type":"recent"}
         * created_at : Tue Dec 22 10:45:19 +0000 2015
         * id : 679251361263915008
         * id_str : 679251361263915008
         * text : Não demonstrar, não significa não sentir.
         * source : <a href="http://www.hootsuite.com" rel="nofollow">Hootsuite</a>
         * truncated : false
         * in_reply_to_status_id : null
         * in_reply_to_status_id_str : null
         * in_reply_to_user_id : null
         * in_reply_to_user_id_str : null
         * in_reply_to_screen_name : null
         * user : {"id":369645502,"id_str":"369645502","name":"Querido Jeito س","screen_name":"QueridoJeito","location":"","description":"Frases, pensamentos e sentimentos. Trechos de séries, filmes e músicas.\nContato:  queridojeito@gmail.com","url":"https://t.co/FY2IoJbU0O","entities":{"url":{"urls":[{"url":"https://t.co/FY2IoJbU0O","expanded_url":"https://instagram.com/queridojeito","display_url":"instagram.com/queridojeito","indices":[0,23]}]},"description":{"urls":[]}},"protected":false,"followers_count":955765,"friends_count":664236,"listed_count":327,"created_at":"Wed Sep 07 18:11:37 +0000 2011","favourites_count":5110,"utc_offset":-7200,"time_zone":"Brasilia","geo_enabled":false,"verified":false,"statuses_count":24819,"lang":"pt","contributors_enabled":false,"is_translator":false,"is_translation_enabled":false,"profile_background_color":"131516","profile_background_image_url":"http://pbs.twimg.com/profile_background_images/441050703625064448/JDU_IICQ.jpeg","profile_background_image_url_https":"https://pbs.twimg.com/profile_background_images/441050703625064448/JDU_IICQ.jpeg","profile_background_tile":true,"profile_image_url":"http://pbs.twimg.com/profile_images/665344116453187584/pAhf2S6O_normal.jpg","profile_image_url_https":"https://pbs.twimg.com/profile_images/665344116453187584/pAhf2S6O_normal.jpg","profile_banner_url":"https://pbs.twimg.com/profile_banners/369645502/1450228771","profile_link_color":"131516","profile_sidebar_border_color":"000000","profile_sidebar_fill_color":"EFEFEF","profile_text_color":"333333","profile_use_background_image":true,"has_extended_profile":false,"default_profile":false,"default_profile_image":false,"following":false,"follow_request_sent":false,"notifications":false}
         * geo : null
         * coordinates : null
         * place : null
         * contributors : null
         * is_quote_status : false
         * retweet_count : 56
         * favorite_count : 48
         * entities : {"hashtags":[],"symbols":[],"user_mentions":[],"urls":[]}
         * favorited : false
         * retweeted : false
         * lang : pt
         */

        private RetweetedStatusEntity retweeted_status;
        private boolean is_quote_status;
        private int retweet_count;
        private int favorite_count;
        private EntitiesEntity entities;
        private boolean favorited;
        private boolean retweeted;
        private String lang;

        public void setMetadata(MetadataEntity metadata) {
            this.metadata = metadata;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setId_str(String id_str) {
            this.id_str = id_str;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public void setTruncated(boolean truncated) {
            this.truncated = truncated;
        }

        public void setIn_reply_to_status_id(Object in_reply_to_status_id) {
            this.in_reply_to_status_id = in_reply_to_status_id;
        }

        public void setIn_reply_to_status_id_str(Object in_reply_to_status_id_str) {
            this.in_reply_to_status_id_str = in_reply_to_status_id_str;
        }

        public void setIn_reply_to_user_id(Object in_reply_to_user_id) {
            this.in_reply_to_user_id = in_reply_to_user_id;
        }

        public void setIn_reply_to_user_id_str(Object in_reply_to_user_id_str) {
            this.in_reply_to_user_id_str = in_reply_to_user_id_str;
        }

        public void setIn_reply_to_screen_name(Object in_reply_to_screen_name) {
            this.in_reply_to_screen_name = in_reply_to_screen_name;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public void setGeo(Object geo) {
            this.geo = geo;
        }

        public void setCoordinates(Object coordinates) {
            this.coordinates = coordinates;
        }

        public void setPlace(Object place) {
            this.place = place;
        }

        public void setContributors(Object contributors) {
            this.contributors = contributors;
        }

        public void setRetweeted_status(RetweetedStatusEntity retweeted_status) {
            this.retweeted_status = retweeted_status;
        }

        public void setIs_quote_status(boolean is_quote_status) {
            this.is_quote_status = is_quote_status;
        }

        public void setRetweet_count(int retweet_count) {
            this.retweet_count = retweet_count;
        }

        public void setFavorite_count(int favorite_count) {
            this.favorite_count = favorite_count;
        }

        public void setEntities(EntitiesEntity entities) {
            this.entities = entities;
        }

        public void setFavorited(boolean favorited) {
            this.favorited = favorited;
        }

        public void setRetweeted(boolean retweeted) {
            this.retweeted = retweeted;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public MetadataEntity getMetadata() {
            return metadata;
        }

        public String getCreated_at() {
            return created_at;
        }

        public long getId() {
            return id;
        }

        public String getId_str() {
            return id_str;
        }

        public String getText() {
            return text;
        }

        public String getSource() {
            return source;
        }

        public boolean isTruncated() {
            return truncated;
        }

        public Object getIn_reply_to_status_id() {
            return in_reply_to_status_id;
        }

        public Object getIn_reply_to_status_id_str() {
            return in_reply_to_status_id_str;
        }

        public Object getIn_reply_to_user_id() {
            return in_reply_to_user_id;
        }

        public Object getIn_reply_to_user_id_str() {
            return in_reply_to_user_id_str;
        }

        public Object getIn_reply_to_screen_name() {
            return in_reply_to_screen_name;
        }

        public UserEntity getUser() {
            return user;
        }

        public Object getGeo() {
            return geo;
        }

        public Object getCoordinates() {
            return coordinates;
        }

        public Object getPlace() {
            return place;
        }

        public Object getContributors() {
            return contributors;
        }

        public RetweetedStatusEntity getRetweeted_status() {
            return retweeted_status;
        }

        public boolean isIs_quote_status() {
            return is_quote_status;
        }

        public int getRetweet_count() {
            return retweet_count;
        }

        public int getFavorite_count() {
            return favorite_count;
        }

        public EntitiesEntity getEntities() {
            return entities;
        }

        public boolean isFavorited() {
            return favorited;
        }

        public boolean isRetweeted() {
            return retweeted;
        }

        public String getLang() {
            return lang;
        }

        public static class MetadataEntity {
            private String iso_language_code;
            private String result_type;

            public void setIso_language_code(String iso_language_code) {
                this.iso_language_code = iso_language_code;
            }

            public void setResult_type(String result_type) {
                this.result_type = result_type;
            }

            public String getIso_language_code() {
                return iso_language_code;
            }

            public String getResult_type() {
                return result_type;
            }
        }

        public static class UserEntity {
            private long id;
            private String id_str;
            private String name;
            private String screen_name;
            private String location;
            private String description;
            private Object url;
            /**
             * description : {"urls":[]}
             */

            private EntitiesEntity entities;
            @SerializedName("protected")
            private boolean protectedX;
            private int followers_count;
            private int friends_count;
            private int listed_count;
            private String created_at;
            private int favourites_count;
            private Object utc_offset;
            private Object time_zone;
            private boolean geo_enabled;
            private boolean verified;
            private int statuses_count;
            private String lang;
            private boolean contributors_enabled;
            private boolean is_translator;
            private boolean is_translation_enabled;
            private String profile_background_color;
            private String profile_background_image_url;
            private String profile_background_image_url_https;
            private boolean profile_background_tile;
            private String profile_image_url;
            private String profile_image_url_https;
            private String profile_banner_url;
            private String profile_link_color;
            private String profile_sidebar_border_color;
            private String profile_sidebar_fill_color;
            private String profile_text_color;
            private boolean profile_use_background_image;
            private boolean has_extended_profile;
            private boolean default_profile;
            private boolean default_profile_image;
            private boolean following;
            private boolean follow_request_sent;
            private boolean notifications;

            public void setId(long id) {
                this.id = id;
            }

            public void setId_str(String id_str) {
                this.id_str = id_str;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setScreen_name(String screen_name) {
                this.screen_name = screen_name;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public void setUrl(Object url) {
                this.url = url;
            }

            public void setEntities(EntitiesEntity entities) {
                this.entities = entities;
            }

            public void setProtectedX(boolean protectedX) {
                this.protectedX = protectedX;
            }

            public void setFollowers_count(int followers_count) {
                this.followers_count = followers_count;
            }

            public void setFriends_count(int friends_count) {
                this.friends_count = friends_count;
            }

            public void setListed_count(int listed_count) {
                this.listed_count = listed_count;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public void setFavourites_count(int favourites_count) {
                this.favourites_count = favourites_count;
            }

            public void setUtc_offset(Object utc_offset) {
                this.utc_offset = utc_offset;
            }

            public void setTime_zone(Object time_zone) {
                this.time_zone = time_zone;
            }

            public void setGeo_enabled(boolean geo_enabled) {
                this.geo_enabled = geo_enabled;
            }

            public void setVerified(boolean verified) {
                this.verified = verified;
            }

            public void setStatuses_count(int statuses_count) {
                this.statuses_count = statuses_count;
            }

            public void setLang(String lang) {
                this.lang = lang;
            }

            public void setContributors_enabled(boolean contributors_enabled) {
                this.contributors_enabled = contributors_enabled;
            }

            public void setIs_translator(boolean is_translator) {
                this.is_translator = is_translator;
            }

            public void setIs_translation_enabled(boolean is_translation_enabled) {
                this.is_translation_enabled = is_translation_enabled;
            }

            public void setProfile_background_color(String profile_background_color) {
                this.profile_background_color = profile_background_color;
            }

            public void setProfile_background_image_url(String profile_background_image_url) {
                this.profile_background_image_url = profile_background_image_url;
            }

            public void setProfile_background_image_url_https(String profile_background_image_url_https) {
                this.profile_background_image_url_https = profile_background_image_url_https;
            }

            public void setProfile_background_tile(boolean profile_background_tile) {
                this.profile_background_tile = profile_background_tile;
            }

            public void setProfile_image_url(String profile_image_url) {
                this.profile_image_url = profile_image_url;
            }

            public void setProfile_image_url_https(String profile_image_url_https) {
                this.profile_image_url_https = profile_image_url_https;
            }

            public void setProfile_banner_url(String profile_banner_url) {
                this.profile_banner_url = profile_banner_url;
            }

            public void setProfile_link_color(String profile_link_color) {
                this.profile_link_color = profile_link_color;
            }

            public void setProfile_sidebar_border_color(String profile_sidebar_border_color) {
                this.profile_sidebar_border_color = profile_sidebar_border_color;
            }

            public void setProfile_sidebar_fill_color(String profile_sidebar_fill_color) {
                this.profile_sidebar_fill_color = profile_sidebar_fill_color;
            }

            public void setProfile_text_color(String profile_text_color) {
                this.profile_text_color = profile_text_color;
            }

            public void setProfile_use_background_image(boolean profile_use_background_image) {
                this.profile_use_background_image = profile_use_background_image;
            }

            public void setHas_extended_profile(boolean has_extended_profile) {
                this.has_extended_profile = has_extended_profile;
            }

            public void setDefault_profile(boolean default_profile) {
                this.default_profile = default_profile;
            }

            public void setDefault_profile_image(boolean default_profile_image) {
                this.default_profile_image = default_profile_image;
            }

            public void setFollowing(boolean following) {
                this.following = following;
            }

            public void setFollow_request_sent(boolean follow_request_sent) {
                this.follow_request_sent = follow_request_sent;
            }

            public void setNotifications(boolean notifications) {
                this.notifications = notifications;
            }

            public long getId() {
                return id;
            }

            public String getId_str() {
                return id_str;
            }

            public String getName() {
                return name;
            }

            public String getScreen_name() {
                return screen_name;
            }

            public String getLocation() {
                return location;
            }

            public String getDescription() {
                return description;
            }

            public Object getUrl() {
                return url;
            }

            public EntitiesEntity getEntities() {
                return entities;
            }

            public boolean isProtectedX() {
                return protectedX;
            }

            public int getFollowers_count() {
                return followers_count;
            }

            public int getFriends_count() {
                return friends_count;
            }

            public int getListed_count() {
                return listed_count;
            }

            public String getCreated_at() {
                return created_at;
            }

            public int getFavourites_count() {
                return favourites_count;
            }

            public Object getUtc_offset() {
                return utc_offset;
            }

            public Object getTime_zone() {
                return time_zone;
            }

            public boolean isGeo_enabled() {
                return geo_enabled;
            }

            public boolean isVerified() {
                return verified;
            }

            public int getStatuses_count() {
                return statuses_count;
            }

            public String getLang() {
                return lang;
            }

            public boolean isContributors_enabled() {
                return contributors_enabled;
            }

            public boolean isIs_translator() {
                return is_translator;
            }

            public boolean isIs_translation_enabled() {
                return is_translation_enabled;
            }

            public String getProfile_background_color() {
                return profile_background_color;
            }

            public String getProfile_background_image_url() {
                return profile_background_image_url;
            }

            public String getProfile_background_image_url_https() {
                return profile_background_image_url_https;
            }

            public boolean isProfile_background_tile() {
                return profile_background_tile;
            }

            public String getProfile_image_url() {
                return profile_image_url;
            }

            public String getProfile_image_url_https() {
                return profile_image_url_https;
            }

            public String getProfile_banner_url() {
                return profile_banner_url;
            }

            public String getProfile_link_color() {
                return profile_link_color;
            }

            public String getProfile_sidebar_border_color() {
                return profile_sidebar_border_color;
            }

            public String getProfile_sidebar_fill_color() {
                return profile_sidebar_fill_color;
            }

            public String getProfile_text_color() {
                return profile_text_color;
            }

            public boolean isProfile_use_background_image() {
                return profile_use_background_image;
            }

            public boolean isHas_extended_profile() {
                return has_extended_profile;
            }

            public boolean isDefault_profile() {
                return default_profile;
            }

            public boolean isDefault_profile_image() {
                return default_profile_image;
            }

            public boolean isFollowing() {
                return following;
            }

            public boolean isFollow_request_sent() {
                return follow_request_sent;
            }

            public boolean isNotifications() {
                return notifications;
            }

            public static class EntitiesEntity {
                private DescriptionEntity description;

                public void setDescription(DescriptionEntity description) {
                    this.description = description;
                }

                public DescriptionEntity getDescription() {
                    return description;
                }

                public static class DescriptionEntity {
                    private List<?> urls;

                    public void setUrls(List<?> urls) {
                        this.urls = urls;
                    }

                    public List<?> getUrls() {
                        return urls;
                    }
                }
            }
        }

        public static class RetweetedStatusEntity {
            /**
             * iso_language_code : pt
             * result_type : recent
             */

            private MetadataEntity metadata;
            private String created_at;
            private long id;
            private String id_str;
            private String text;
            private String source;
            private boolean truncated;
            private Object in_reply_to_status_id;
            private Object in_reply_to_status_id_str;
            private Object in_reply_to_user_id;
            private Object in_reply_to_user_id_str;
            private Object in_reply_to_screen_name;
            /**
             * id : 369645502
             * id_str : 369645502
             * name : Querido Jeito س
             * screen_name : QueridoJeito
             * location :
             * description : Frases, pensamentos e sentimentos. Trechos de séries, filmes e músicas.
             Contato:  queridojeito@gmail.com
             * url : https://t.co/FY2IoJbU0O
             * entities : {"url":{"urls":[{"url":"https://t.co/FY2IoJbU0O","expanded_url":"https://instagram.com/queridojeito","display_url":"instagram.com/queridojeito","indices":[0,23]}]},"description":{"urls":[]}}
             * protected : false
             * followers_count : 955765
             * friends_count : 664236
             * listed_count : 327
             * created_at : Wed Sep 07 18:11:37 +0000 2011
             * favourites_count : 5110
             * utc_offset : -7200
             * time_zone : Brasilia
             * geo_enabled : false
             * verified : false
             * statuses_count : 24819
             * lang : pt
             * contributors_enabled : false
             * is_translator : false
             * is_translation_enabled : false
             * profile_background_color : 131516
             * profile_background_image_url : http://pbs.twimg.com/profile_background_images/441050703625064448/JDU_IICQ.jpeg
             * profile_background_image_url_https : https://pbs.twimg.com/profile_background_images/441050703625064448/JDU_IICQ.jpeg
             * profile_background_tile : true
             * profile_image_url : http://pbs.twimg.com/profile_images/665344116453187584/pAhf2S6O_normal.jpg
             * profile_image_url_https : https://pbs.twimg.com/profile_images/665344116453187584/pAhf2S6O_normal.jpg
             * profile_banner_url : https://pbs.twimg.com/profile_banners/369645502/1450228771
             * profile_link_color : 131516
             * profile_sidebar_border_color : 000000
             * profile_sidebar_fill_color : EFEFEF
             * profile_text_color : 333333
             * profile_use_background_image : true
             * has_extended_profile : false
             * default_profile : false
             * default_profile_image : false
             * following : false
             * follow_request_sent : false
             * notifications : false
             */

            private UserEntity user;
            private Object geo;
            private Object coordinates;
            private Object place;
            private Object contributors;
            private boolean is_quote_status;
            private int retweet_count;
            private int favorite_count;
            private EntitiesEntity entities;
            private boolean favorited;
            private boolean retweeted;
            private String lang;

            public void setMetadata(MetadataEntity metadata) {
                this.metadata = metadata;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public void setId(long id) {
                this.id = id;
            }

            public void setId_str(String id_str) {
                this.id_str = id_str;
            }

            public void setText(String text) {
                this.text = text;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public void setTruncated(boolean truncated) {
                this.truncated = truncated;
            }

            public void setIn_reply_to_status_id(Object in_reply_to_status_id) {
                this.in_reply_to_status_id = in_reply_to_status_id;
            }

            public void setIn_reply_to_status_id_str(Object in_reply_to_status_id_str) {
                this.in_reply_to_status_id_str = in_reply_to_status_id_str;
            }

            public void setIn_reply_to_user_id(Object in_reply_to_user_id) {
                this.in_reply_to_user_id = in_reply_to_user_id;
            }

            public void setIn_reply_to_user_id_str(Object in_reply_to_user_id_str) {
                this.in_reply_to_user_id_str = in_reply_to_user_id_str;
            }

            public void setIn_reply_to_screen_name(Object in_reply_to_screen_name) {
                this.in_reply_to_screen_name = in_reply_to_screen_name;
            }

            public void setUser(UserEntity user) {
                this.user = user;
            }

            public void setGeo(Object geo) {
                this.geo = geo;
            }

            public void setCoordinates(Object coordinates) {
                this.coordinates = coordinates;
            }

            public void setPlace(Object place) {
                this.place = place;
            }

            public void setContributors(Object contributors) {
                this.contributors = contributors;
            }

            public void setIs_quote_status(boolean is_quote_status) {
                this.is_quote_status = is_quote_status;
            }

            public void setRetweet_count(int retweet_count) {
                this.retweet_count = retweet_count;
            }

            public void setFavorite_count(int favorite_count) {
                this.favorite_count = favorite_count;
            }

            public void setEntities(EntitiesEntity entities) {
                this.entities = entities;
            }

            public void setFavorited(boolean favorited) {
                this.favorited = favorited;
            }

            public void setRetweeted(boolean retweeted) {
                this.retweeted = retweeted;
            }

            public void setLang(String lang) {
                this.lang = lang;
            }

            public MetadataEntity getMetadata() {
                return metadata;
            }

            public String getCreated_at() {
                return created_at;
            }

            public long getId() {
                return id;
            }

            public String getId_str() {
                return id_str;
            }

            public String getText() {
                return text;
            }

            public String getSource() {
                return source;
            }

            public boolean isTruncated() {
                return truncated;
            }

            public Object getIn_reply_to_status_id() {
                return in_reply_to_status_id;
            }

            public Object getIn_reply_to_status_id_str() {
                return in_reply_to_status_id_str;
            }

            public Object getIn_reply_to_user_id() {
                return in_reply_to_user_id;
            }

            public Object getIn_reply_to_user_id_str() {
                return in_reply_to_user_id_str;
            }

            public Object getIn_reply_to_screen_name() {
                return in_reply_to_screen_name;
            }

            public UserEntity getUser() {
                return user;
            }

            public Object getGeo() {
                return geo;
            }

            public Object getCoordinates() {
                return coordinates;
            }

            public Object getPlace() {
                return place;
            }

            public Object getContributors() {
                return contributors;
            }

            public boolean isIs_quote_status() {
                return is_quote_status;
            }

            public int getRetweet_count() {
                return retweet_count;
            }

            public int getFavorite_count() {
                return favorite_count;
            }

            public EntitiesEntity getEntities() {
                return entities;
            }

            public boolean isFavorited() {
                return favorited;
            }

            public boolean isRetweeted() {
                return retweeted;
            }

            public String getLang() {
                return lang;
            }

            public static class MetadataEntity {
                private String iso_language_code;
                private String result_type;

                public void setIso_language_code(String iso_language_code) {
                    this.iso_language_code = iso_language_code;
                }

                public void setResult_type(String result_type) {
                    this.result_type = result_type;
                }

                public String getIso_language_code() {
                    return iso_language_code;
                }

                public String getResult_type() {
                    return result_type;
                }
            }

            public static class UserEntity {
                private int id;
                private String id_str;
                private String name;
                private String screen_name;
                private String location;
                private String description;
                private String url;
                /**
                 * url : {"urls":[{"url":"https://t.co/FY2IoJbU0O","expanded_url":"https://instagram.com/queridojeito","display_url":"instagram.com/queridojeito","indices":[0,23]}]}
                 * description : {"urls":[]}
                 */

                private EntitiesEntity entities;
                @SerializedName("protected")
                private boolean protectedX;
                private int followers_count;
                private int friends_count;
                private int listed_count;
                private String created_at;
                private int favourites_count;
                private int utc_offset;
                private String time_zone;
                private boolean geo_enabled;
                private boolean verified;
                private int statuses_count;
                private String lang;
                private boolean contributors_enabled;
                private boolean is_translator;
                private boolean is_translation_enabled;
                private String profile_background_color;
                private String profile_background_image_url;
                private String profile_background_image_url_https;
                private boolean profile_background_tile;
                private String profile_image_url;
                private String profile_image_url_https;
                private String profile_banner_url;
                private String profile_link_color;
                private String profile_sidebar_border_color;
                private String profile_sidebar_fill_color;
                private String profile_text_color;
                private boolean profile_use_background_image;
                private boolean has_extended_profile;
                private boolean default_profile;
                private boolean default_profile_image;
                private boolean following;
                private boolean follow_request_sent;
                private boolean notifications;

                public void setId(int id) {
                    this.id = id;
                }

                public void setId_str(String id_str) {
                    this.id_str = id_str;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setScreen_name(String screen_name) {
                    this.screen_name = screen_name;
                }

                public void setLocation(String location) {
                    this.location = location;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public void setEntities(EntitiesEntity entities) {
                    this.entities = entities;
                }

                public void setProtectedX(boolean protectedX) {
                    this.protectedX = protectedX;
                }

                public void setFollowers_count(int followers_count) {
                    this.followers_count = followers_count;
                }

                public void setFriends_count(int friends_count) {
                    this.friends_count = friends_count;
                }

                public void setListed_count(int listed_count) {
                    this.listed_count = listed_count;
                }

                public void setCreated_at(String created_at) {
                    this.created_at = created_at;
                }

                public void setFavourites_count(int favourites_count) {
                    this.favourites_count = favourites_count;
                }

                public void setUtc_offset(int utc_offset) {
                    this.utc_offset = utc_offset;
                }

                public void setTime_zone(String time_zone) {
                    this.time_zone = time_zone;
                }

                public void setGeo_enabled(boolean geo_enabled) {
                    this.geo_enabled = geo_enabled;
                }

                public void setVerified(boolean verified) {
                    this.verified = verified;
                }

                public void setStatuses_count(int statuses_count) {
                    this.statuses_count = statuses_count;
                }

                public void setLang(String lang) {
                    this.lang = lang;
                }

                public void setContributors_enabled(boolean contributors_enabled) {
                    this.contributors_enabled = contributors_enabled;
                }

                public void setIs_translator(boolean is_translator) {
                    this.is_translator = is_translator;
                }

                public void setIs_translation_enabled(boolean is_translation_enabled) {
                    this.is_translation_enabled = is_translation_enabled;
                }

                public void setProfile_background_color(String profile_background_color) {
                    this.profile_background_color = profile_background_color;
                }

                public void setProfile_background_image_url(String profile_background_image_url) {
                    this.profile_background_image_url = profile_background_image_url;
                }

                public void setProfile_background_image_url_https(String profile_background_image_url_https) {
                    this.profile_background_image_url_https = profile_background_image_url_https;
                }

                public void setProfile_background_tile(boolean profile_background_tile) {
                    this.profile_background_tile = profile_background_tile;
                }

                public void setProfile_image_url(String profile_image_url) {
                    this.profile_image_url = profile_image_url;
                }

                public void setProfile_image_url_https(String profile_image_url_https) {
                    this.profile_image_url_https = profile_image_url_https;
                }

                public void setProfile_banner_url(String profile_banner_url) {
                    this.profile_banner_url = profile_banner_url;
                }

                public void setProfile_link_color(String profile_link_color) {
                    this.profile_link_color = profile_link_color;
                }

                public void setProfile_sidebar_border_color(String profile_sidebar_border_color) {
                    this.profile_sidebar_border_color = profile_sidebar_border_color;
                }

                public void setProfile_sidebar_fill_color(String profile_sidebar_fill_color) {
                    this.profile_sidebar_fill_color = profile_sidebar_fill_color;
                }

                public void setProfile_text_color(String profile_text_color) {
                    this.profile_text_color = profile_text_color;
                }

                public void setProfile_use_background_image(boolean profile_use_background_image) {
                    this.profile_use_background_image = profile_use_background_image;
                }

                public void setHas_extended_profile(boolean has_extended_profile) {
                    this.has_extended_profile = has_extended_profile;
                }

                public void setDefault_profile(boolean default_profile) {
                    this.default_profile = default_profile;
                }

                public void setDefault_profile_image(boolean default_profile_image) {
                    this.default_profile_image = default_profile_image;
                }

                public void setFollowing(boolean following) {
                    this.following = following;
                }

                public void setFollow_request_sent(boolean follow_request_sent) {
                    this.follow_request_sent = follow_request_sent;
                }

                public void setNotifications(boolean notifications) {
                    this.notifications = notifications;
                }

                public int getId() {
                    return id;
                }

                public String getId_str() {
                    return id_str;
                }

                public String getName() {
                    return name;
                }

                public String getScreen_name() {
                    return screen_name;
                }

                public String getLocation() {
                    return location;
                }

                public String getDescription() {
                    return description;
                }

                public String getUrl() {
                    return url;
                }

                public EntitiesEntity getEntities() {
                    return entities;
                }

                public boolean isProtectedX() {
                    return protectedX;
                }

                public int getFollowers_count() {
                    return followers_count;
                }

                public int getFriends_count() {
                    return friends_count;
                }

                public int getListed_count() {
                    return listed_count;
                }

                public String getCreated_at() {
                    return created_at;
                }

                public int getFavourites_count() {
                    return favourites_count;
                }

                public int getUtc_offset() {
                    return utc_offset;
                }

                public String getTime_zone() {
                    return time_zone;
                }

                public boolean isGeo_enabled() {
                    return geo_enabled;
                }

                public boolean isVerified() {
                    return verified;
                }

                public int getStatuses_count() {
                    return statuses_count;
                }

                public String getLang() {
                    return lang;
                }

                public boolean isContributors_enabled() {
                    return contributors_enabled;
                }

                public boolean isIs_translator() {
                    return is_translator;
                }

                public boolean isIs_translation_enabled() {
                    return is_translation_enabled;
                }

                public String getProfile_background_color() {
                    return profile_background_color;
                }

                public String getProfile_background_image_url() {
                    return profile_background_image_url;
                }

                public String getProfile_background_image_url_https() {
                    return profile_background_image_url_https;
                }

                public boolean isProfile_background_tile() {
                    return profile_background_tile;
                }

                public String getProfile_image_url() {
                    return profile_image_url;
                }

                public String getProfile_image_url_https() {
                    return profile_image_url_https;
                }

                public String getProfile_banner_url() {
                    return profile_banner_url;
                }

                public String getProfile_link_color() {
                    return profile_link_color;
                }

                public String getProfile_sidebar_border_color() {
                    return profile_sidebar_border_color;
                }

                public String getProfile_sidebar_fill_color() {
                    return profile_sidebar_fill_color;
                }

                public String getProfile_text_color() {
                    return profile_text_color;
                }

                public boolean isProfile_use_background_image() {
                    return profile_use_background_image;
                }

                public boolean isHas_extended_profile() {
                    return has_extended_profile;
                }

                public boolean isDefault_profile() {
                    return default_profile;
                }

                public boolean isDefault_profile_image() {
                    return default_profile_image;
                }

                public boolean isFollowing() {
                    return following;
                }

                public boolean isFollow_request_sent() {
                    return follow_request_sent;
                }

                public boolean isNotifications() {
                    return notifications;
                }

                public static class EntitiesEntity {
                    private UrlEntity url;
                    private DescriptionEntity description;

                    public void setUrl(UrlEntity url) {
                        this.url = url;
                    }

                    public void setDescription(DescriptionEntity description) {
                        this.description = description;
                    }

                    public UrlEntity getUrl() {
                        return url;
                    }

                    public DescriptionEntity getDescription() {
                        return description;
                    }

                    public static class UrlEntity {
                        /**
                         * url : https://t.co/FY2IoJbU0O
                         * expanded_url : https://instagram.com/queridojeito
                         * display_url : instagram.com/queridojeito
                         * indices : [0,23]
                         */

                        private List<UrlsEntity> urls;

                        public void setUrls(List<UrlsEntity> urls) {
                            this.urls = urls;
                        }

                        public List<UrlsEntity> getUrls() {
                            return urls;
                        }

                        public static class UrlsEntity {
                            private String url;
                            private String expanded_url;
                            private String display_url;
                            private List<Integer> indices;

                            public void setUrl(String url) {
                                this.url = url;
                            }

                            public void setExpanded_url(String expanded_url) {
                                this.expanded_url = expanded_url;
                            }

                            public void setDisplay_url(String display_url) {
                                this.display_url = display_url;
                            }

                            public void setIndices(List<Integer> indices) {
                                this.indices = indices;
                            }

                            public String getUrl() {
                                return url;
                            }

                            public String getExpanded_url() {
                                return expanded_url;
                            }

                            public String getDisplay_url() {
                                return display_url;
                            }

                            public List<Integer> getIndices() {
                                return indices;
                            }
                        }
                    }

                    public static class DescriptionEntity {
                        private List<?> urls;

                        public void setUrls(List<?> urls) {
                            this.urls = urls;
                        }

                        public List<?> getUrls() {
                            return urls;
                        }
                    }
                }
            }

            public static class EntitiesEntity {
                private List<?> hashtags;
                private List<?> symbols;
                private List<?> user_mentions;
                private List<?> urls;

                public void setHashtags(List<?> hashtags) {
                    this.hashtags = hashtags;
                }

                public void setSymbols(List<?> symbols) {
                    this.symbols = symbols;
                }

                public void setUser_mentions(List<?> user_mentions) {
                    this.user_mentions = user_mentions;
                }

                public void setUrls(List<?> urls) {
                    this.urls = urls;
                }

                public List<?> getHashtags() {
                    return hashtags;
                }

                public List<?> getSymbols() {
                    return symbols;
                }

                public List<?> getUser_mentions() {
                    return user_mentions;
                }

                public List<?> getUrls() {
                    return urls;
                }
            }
        }

        public static class EntitiesEntity {
            private List<?> hashtags;
            private List<?> symbols;
            /**
             * screen_name : QueridoJeito
             * name : Querido Jeito س
             * id : 369645502
             * id_str : 369645502
             * indices : [3,16]
             */

            private List<UserMentionsEntity> user_mentions;
            private List<?> urls;

            public void setHashtags(List<?> hashtags) {
                this.hashtags = hashtags;
            }

            public void setSymbols(List<?> symbols) {
                this.symbols = symbols;
            }

            public void setUser_mentions(List<UserMentionsEntity> user_mentions) {
                this.user_mentions = user_mentions;
            }

            public void setUrls(List<?> urls) {
                this.urls = urls;
            }

            public List<?> getHashtags() {
                return hashtags;
            }

            public List<?> getSymbols() {
                return symbols;
            }

            public List<UserMentionsEntity> getUser_mentions() {
                return user_mentions;
            }

            public List<?> getUrls() {
                return urls;
            }

            public static class UserMentionsEntity {
                private String screen_name;
                private String name;
                private int id;
                private String id_str;
                private List<Integer> indices;

                public void setScreen_name(String screen_name) {
                    this.screen_name = screen_name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setId_str(String id_str) {
                    this.id_str = id_str;
                }

                public void setIndices(List<Integer> indices) {
                    this.indices = indices;
                }

                public String getScreen_name() {
                    return screen_name;
                }

                public String getName() {
                    return name;
                }

                public int getId() {
                    return id;
                }

                public String getId_str() {
                    return id_str;
                }

                public List<Integer> getIndices() {
                    return indices;
                }
            }
        }
    }
}
