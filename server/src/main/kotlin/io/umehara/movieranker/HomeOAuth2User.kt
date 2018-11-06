package io.umehara.movieranker

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.oauth2.core.user.OAuth2User
import java.util.*


/**
 * The JSON response will be
 *
 * <pre>`
 * {
 * "id": "abcedef",
 * "email": "ichiro@example.com",
 * "name": {
 * "givenName": "Ichiro",
 * "familyName: "Suzuki"
 * }
 * }
`</pre> *
 *
 * @see org.springframework.security.oauth2.client.userinfo.CustomUserTypesOAuth2UserService
 */
class HomeOAuth2User @JsonCreator
constructor(@param:JsonProperty("id") val id: String,
            @param:JsonProperty("email") val email: String,
            @JsonProperty("name") name: Map<String, String>) : OAuth2User {
    private val authorities = AuthorityUtils
            .createAuthorityList("ROLE_USER")
    val givenName: String
    val familyName: String
    private val attributes: Map<String, Any>

    init {
        this.givenName = name["givenName"] ?: "given name"
        this.familyName = name["familyName"] ?: "family name"
        val attr = LinkedHashMap<String, Any>()
        attr["id"] = this.id
        attr["email"] = this.email
        attr.putAll(name)
        this.attributes = Collections.unmodifiableMap(attr)
    }

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return this.authorities
    }

    override fun getAttributes(): Map<String, Any> {
        return this.attributes
    }

    override fun getName(): String {
        return this.email
    }

    override fun toString(): String {
        return ("HomeOAuth2User{" + "authorities=" + authorities + ", id='" + id + '\''.toString()
                + ", email='" + email + '\''.toString() + ", givenName='" + givenName + '\''.toString()
                + ", familyName='" + familyName + '\''.toString() + ", attributes=" + attributes
                + '}'.toString())
    }
}
