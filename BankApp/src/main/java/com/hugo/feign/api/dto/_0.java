
package com.hugo.feign.api.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "1",
    "2"
})
@Generated("jsonschema2pojo")
public class _0 {

    @JsonProperty("1")
    private List<String> _1 = null;
    @JsonProperty("2")
    private List<String> _2 = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("1")
    public List<String> get1() {
        return _1;
    }

    @JsonProperty("1")
    public void set1(List<String> _1) {
        this._1 = _1;
    }

    @JsonProperty("2")
    public List<String> get2() {
        return _2;
    }

    @JsonProperty("2")
    public void set2(List<String> _2) {
        this._2 = _2;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
