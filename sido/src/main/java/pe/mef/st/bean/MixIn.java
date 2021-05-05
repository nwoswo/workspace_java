package pe.mef.st.bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonFilter("myFilter")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class MixIn {
}