/**
 * personium.io
 * Copyright 2014 FUJITSU LIMITED
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.personium.core.bar.jackson;

import org.json.simple.JSONObject;
import org.odata4j.core.OEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * barファイル内のRelation定義用JSONファイル読み込み用Mapping定義クラス.
 */
public class JSONRelation implements JSONMappedObject {

    /** Name. */
    @JsonProperty("Name")
    private String name;

    /**
     * Create new instance.
     * @param entity Source entity
     * @return JSONRelation instance.
     */
    public static JSONRelation newInstance(OEntity entity) {
        JSONRelation instance = new JSONRelation();
        instance.setName(entity.getProperty("Name", String.class).getValue());
        return instance;
    }

    /**
     * Nameプロパティの取得.
     * @return Name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Nameプロパティの設定.
     * @param name Name.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    @JsonIgnore
    @SuppressWarnings("unchecked")
    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        json.put("Name", this.name);
        return json;
    }
}