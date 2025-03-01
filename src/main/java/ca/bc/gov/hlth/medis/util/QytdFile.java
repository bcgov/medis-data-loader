package ca.bc.gov.hlth.medis.util;

public enum QytdFile {

	LTC_BED_YTD_MAX_OCCUPANCY("ltc_bed_ytd_max_occupancy"),	
	LTC_BED_YTD_MAX_OCCY_TOTALS ("ltc_bed_ytd_max_occy_totals"),	
	LTC_BED_YTD_OCCUPANCY_RATE("ltc_bed_ytd_occupancy_rate"),
	LTC_BED_YTD_OCCUPANCY_RATE_TOT("ltc_bed_ytd_occupancy_rate_tot"),	
	LTC_BED_YTD_OCCUPIED_DAYS("ltc_bed_ytd_occupied_days"),
	LTC_BED_YTD_OCCUPIED_DAYS_TOT("ltc_bed_ytd_occupied_days_tot"),
	LTC_YTD_COMP_ADD_POS("ltc_ytd_comp_add_pos"),
	LTC_YTD_COMP_BENEFITS("ltc_ytd_comp_benefits"),	
	LTC_YTD_COMP_HRS("ltc_ytd_comp_hrs"),
	LTC_YTD_COMP_HRS_SUBTOTALS("ltc_ytd_comp_hrs_subtotals"),
	LTC_YTD_COMP_HRS_TOTALS("ltc_ytd_comp_hrs_totals"),	
	LTC_YTD_COMP_SAL("ltc_ytd_comp_sal"),
	LTC_YTD_COMP_SAL_SUBTOTALS("ltc_ytd_comp_sal_subtotals"),
	LTC_YTD_COMP_SAL_TOTALS("ltc_ytd_comp_sal_totals"),
	LTC_YTD_DEP("ltc_ytd_dep"),
	LTC_YTD_DEP_SUBTOTALS("ltc_ytd_dep_subtotals"),
	LTC_YTD_DIRECT_CARE_COST("ltc_ytd_direct_care_cost"), 
	LTC_YTD_DIRECT_CARE_COST_SUBS("ltc_ytd_direct_care_cost_subs"),
	LTC_YTD_DIRECT_CARE_HRS("ltc_ytd_direct_care_hrs"),
	LTC_YTD_DIRECT_CARE_HRS_SUBS("ltc_ytd_direct_care_hrs_subs"),
	LTC_YTD_DIRECT_CARE_VACANCY("ltc_ytd_direct_care_vacancy"),
	LTC_YTD_EXP("ltc_ytd_exp"), 
	LTC_YTD_EXP_SUBTOTALS("ltc_ytd_exp_subtotals"), 
	LTC_YTD_REV_SUBTOTALS("ltc_ytd_rev_subtotals"),
	LTC_YTD_REV("ltc_ytd_rev"),
	LTC_YTD_SUBMISSION("ltc_ytd_submission"),
	LTC_YTD_SUM_TOTALS("ltc_ytd_sum_totals");

	public final String filename;

	private QytdFile(String filename) {
		this.filename = filename;
	}

}
