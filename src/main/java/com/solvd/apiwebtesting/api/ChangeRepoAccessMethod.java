package com.solvd.apiwebtesting.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/repos/${repo_name}", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "repositories/patch/rq.json")
@ResponseTemplatePath(path = "repositories/patch/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class ChangeRepoAccessMethod extends AbstractApiMethodV2 {

    public ChangeRepoAccessMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("repo_name", Configuration.getEnvArg("name"));
    }
}
