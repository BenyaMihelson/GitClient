package ua.bogdan_mikhalchenko.mvp_stepbystep.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Shipohvost on 12.05.2017.
 */

public class BranchDTO {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("commit")
    @Expose
    private CommitDTO commit;
    @SerializedName("protection")
    @Expose
    private ProtectionDTO protection;

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The commit
     */
    public CommitDTO getCommit() {
        return commit;
    }

    /**
     * @param commit The commit
     */
    public void setCommit(CommitDTO commit) {
        this.commit = commit;
    }

    /**
     * @return The protection
     */
    public ProtectionDTO getProtection() {
        return protection;
    }

    /**
     * @param protection The protection
     */
    public void setProtection(ProtectionDTO protection) {
        this.protection = protection;
    }

}
