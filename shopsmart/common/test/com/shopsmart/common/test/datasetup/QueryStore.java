package com.shopsmart.common.test.datasetup;

import org.springframework.stereotype.Component;

@Component
public class QueryStore {

	public String insertUserQuery() {
		String insertUserQuery = "MERGE INTO SS_USER USING (VALUES(CAST(1 AS INT))) AS vals(x) ON SS_USER.USERID = vals.x  WHEN NOT MATCHED THEN INSERT  (USERID, USERNAME, LOGINEMAIL, CURRENTPASSWORD, DATECREATED, DATEUPDATED, UPDATEDBY) VALUES (1,'USER1','USER1','USER1PASSWORD','2015-05-07 12:51:35','2015-05-07 12:51:35',0);";
		return insertUserQuery;
	}
}
