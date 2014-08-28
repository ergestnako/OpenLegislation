package gov.nysenate.openleg.dao.bill;

import gov.nysenate.openleg.dao.base.BasicSqlQuery;
import gov.nysenate.openleg.dao.base.SqlTable;

public enum SqlApprovalQuery implements BasicSqlQuery{

    SELECT_APPROVAL_BY_ID(
        "SELECT * FROM ${schema}." + SqlTable.BILL_APPROVAL + "\n" +
        "WHERE year = :year AND approval_number = :approvalNumber"
    ),
    SELECT_APPROVAL_BY_BILL(
        "SELECT * FROM ${schema}." + SqlTable.BILL_APPROVAL + "\n" +
        "WHERE session_year = :sessionYear AND bill_print_no = :billPrintNo"
    ),
    SELECT_APPROVALS_BY_YEAR(
        "SELECT * FROM ${schema}." + SqlTable.BILL_APPROVAL + "\n" +
        "WHERE year = :year "
    ),
    INSERT_APPROVAL(
        "INSERT INTO ${schema}." + SqlTable.BILL_APPROVAL + "\n" +
        "       (  approval_number, year,  bill_print_no, session_year, bill_version, " +
        "            chapter,  signer,  memo_text, last_fragment_id )" + "\n" +
        "VALUES ( :approvalNumber, :year, :billPrintNo,  :sessionYear, :billVersion, " +
        "           :chapter, :signer, :memoText, :lastFragmentId )"
    ),
    UPDATE_APPROVAL(
        "UPDATE ${schema}." + SqlTable.BILL_APPROVAL + "\n" +
        "SET bill_print_no = :billPrintNo, session_year = :sessionYear, bill_version = :billVersion, " +
        "       chapter = :chapter,  signer = :signer,  memo_text = :memoText, last_fragment_id = :lastFragmentId, " +
        "       modified_date_time = now() " + "\n" +
        "WHERE year = :year AND approval_number = :approvalNumber"
    ),
    DELETE_APPROVAL_BY_ID(
        "DELETE FROM ${schema}." + SqlTable.BILL_APPROVAL + "\n" +
        "WHERE year = :year AND approval_number = :approvalNumber"
    ),
    DELETE_APPROVAL_BY_BILL(
        "DELETE FROM ${schema}." + SqlTable.BILL_APPROVAL + "\n" +
        "WHERE session_year = :sessionYear AND bill_print_no = :billPrintNo"
    )
    ;

    private String sql;

    SqlApprovalQuery(String sql){
        this.sql = sql;
    }

    @Override
    public String getSql() {
        return this.sql;
    }
}