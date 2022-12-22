/**
 * @param geo_id represents name of region
 * @param pop represents of population of region
 * @param case_count case covid 19 count
 * @param hosp_count Hospitalizations
 * @param death_count number of deaths
 * @param total_hosp_incidental number of total hospital incidental
 * @param pcr_test_count PCR laboratory test count
 * @param pcr_test_pos_count PCR laboratory positive test results
 * @param pcr_test_pos_percent PCR laboratory positive test percent results
 */
public record Region(String geo_id,
                     double pop,
                     int case_count,
                     int hosp_count,
                     int death_count,
                     int total_hosp_incidental,
                     int pcr_test_count,
                     int pcr_test_pos_count,
                     double pcr_test_pos_percent) {
}
