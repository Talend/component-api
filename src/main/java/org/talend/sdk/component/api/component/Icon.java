/**
 *  Copyright (C) 2006-2017 Talend Inc. - www.talend.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.talend.sdk.component.api.component;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.talend.sdk.component.api.meta.Documentation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Documentation("Associate an icon to a component, only supported on `@PartitionMapper`, `@Processor` and `@Emitter` classes.")
@Target(TYPE)
@Retention(RUNTIME)
public @interface Icon {

    /**
     * @return the icon to associate to the component.
     */
    IconType value();

    /**
     * @return the custom icon key (not in {@link IconType}) to use if {@link Icon#value()} is {@link IconType#CUSTOM}.
     */
    String custom() default "";

    /**
     * See http://talend.surge.sh/icons/
     * generated with
     * {@code var a = document.getElementsByTagName("li");for (i = 0; i < a.length; i++) {var id = a[i].querySelector('svg').id;
     * console.log(id.toUpperCase().replace(/-/g, '_') + '("' + id + "\"),");}} and with appending of DEFAULT and CUSTOM.
     */
    @RequiredArgsConstructor
    enum IconType {
        ACTIVEMQ("activemq"),
        ACTIVITY("activity"),
        AGGREGATE("aggregate"),
        APACHE("apache"),
        ARROW_LEFT("arrow-left"),
        ARROW_RIGHT("arrow-right"),
        BADGE("badge"),
        BEAM("beam"),
        BIGQUERY("bigquery"),
        BLOCK("block"),
        BOARD("board"),
        BUBBLES("bubbles"),
        BURGER("burger"),
        CARET_DOWN("caret-down"),
        CASSANDRA("cassandra"),
        CHAIN("chain"),
        CHECK_CIRCLE("check-circle"),
        CHECK_PLUS("check-plus"),
        CHECK("check"),
        CHEVRON_END("chevron-end"),
        CHEVRON_LEFT("chevron-left"),
        CLOCK("clock"),
        CLOUD_ENGINE("cloud-engine"),
        CLOUD_UPGRADE("cloud-upgrade"),
        CLUSTER("cluster"),
        COG("cog"),
        CONNECTIONS("connections"),
        CROSS("cross"),
        CROSSHAIRS("crosshairs"),
        DATAPREP("dataprep"),
        DATASETS("datasets"),
        DATASTORE("datastore"),
        DB_INPUT("db-input"),
        DOWNLOAD("download"),
        DRAG("drag"),
        ELASTIC("elastic"),
        ENVIRONMENT("environment"),
        EXPANDED("expanded"),
        EXPORT_HISTORY("export-history"),
        EYE("eye"),
        FILE_COG("file-cog"),
        FILE_COMPRESSED("file-compressed"),
        FILE_CONNECT_O("file-connect-o"),
        FILE_CSV_O("file-csv-o"),
        FILE_DATABASE_O("file-database-o"),
        FILE_HDFS_O("file-hdfs-o"),
        FILE_JOB_O("file-job-o"),
        FILE_JSON_O("file-json-o"),
        FILE_MOVE("file-move"),
        FILE_O("file-o"),
        FILE_S3_O("file-s3-o"),
        FILE_SALESFORCE("file-salesforce"),
        FILE_TXT_O("file-txt-o"),
        FILE_XLS_O("file-xls-o"),
        FILE_XLSX_O("file-xlsx-o"),
        FILE_XML_O("file-xml-o"),
        FILES_O("files-o"),
        FILTER_ROW("filter-row"),
        FILTER("filter"),
        FLINK_O("flink-o"),
        FLINK("flink"),
        FLOW_O("flow-o"),
        FLOW_SOURCE_O("flow-source-o"),
        FLOW_STEP_O("flow-step-o"),
        FLOW_TARGET_O("flow-target-o"),
        FLOW_UNDER_PLAN("flow-under-plan"),
        FLOW_UNFINISHED("flow-unfinished"),
        FLOW("flow"),
        FOLDER_CLOSED("folder-closed"),
        FOLDER_SHARED("folder-shared"),
        FOLDER("folder"),
        FULLSCREEN("fullscreen"),
        GROUP_CIRCLE("group-circle"),
        HADOOP("hadoop"),
        HAND_POINTER("hand-pointer"),
        HOME("home"),
        INFO_CIRCLE("info-circle"),
        KAFKA("kafka"),
        LAUNCHER("launcher"),
        LICENSE("license"),
        LINK("link"),
        LOCK("lock"),
        LOCKED("locked"),
        LOGO_DP("logo-dp"),
        LOGO_IC("logo-ic"),
        LOGO_MC("logo-mc"),
        LOGO_SQUARE("logo-square"),
        LOGO("logo"),
        MOST_TRUSTED("most-trusted"),
        NETWORK("network"),
        NORMALIZE("normalize"),
        NOTE("note"),
        PENCIL("pencil"),
        PIN("pin"),
        PLACEHOLDER("placeholder"),
        PLAY("play"),
        PLUS_CIRCLE("plus-circle"),
        PLUS("plus"),
        POSTGRESQL("postgresql"),
        POWER_OFF("power-off"),
        PROJECTS("projects"),
        PUBSUB("pubsub"),
        PYTHON("python"),
        QUESTION_CIRCLE("question-circle"),
        REDO("redo"),
        REFRESH("refresh"),
        REMOTE_ENGINE("remote-engine"),
        REPLICATE("replicate"),
        ROLES("roles"),
        SCHEDULER("scheduler"),
        SEARCH("search"),
        SEMANTIC("semantic"),
        SHARE_ALT("share-alt"),
        SHIELD("shield"),
        SHOW_UNASSIGNED_TASKS("show_unassigned_tasks"),
        SLIDERS("sliders"),
        SORT_19("sort-19"),
        SORT_91("sort-91"),
        SORT_ASC("sort-asc"),
        SORT_AZ("sort-az"),
        SORT_DESC("sort-desc"),
        SORT_ZA("sort-za"),
        SPARK("spark"),
        STAR("star"),
        STOP("stop"),
        STREAMS("streams"),
        TABLE("table"),
        TILES("tiles"),
        TRANSFORMER_WINDOW("transformer-window"),
        TRASH("trash"),
        UNDO("undo"),
        UNLOCKED("unlocked"),
        UPLOAD("upload"),
        USER_CIRCLE("user-circle"),
        WARNING("warning"),
        WEBHOOK("webhook"),
        WINDOW("window"),
        WORKSPACES("workspaces"),
        WORLD("world"),
        ZOOMIN("zoomin"),
        ZOOMOUT("zoomout"),
        CUSTOM("custom"),
        DEFAULT("default");

        @Getter
        private final String key;
    }
}
