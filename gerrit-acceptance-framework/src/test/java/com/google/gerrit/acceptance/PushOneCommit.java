import com.google.common.collect.ImmutableMap;
import com.google.gerrit.server.project.NoSuchChangeException;
import java.util.Map;
    PushOneCommit create(
        ReviewDb db,
        PersonIdent i,
        TestRepository<?> testRepo,
        @Assisted("changeId") String changeId);

    PushOneCommit create(
        ReviewDb db,
        PersonIdent i,
        TestRepository<?> testRepo,
        @Assisted String subject,
        @Assisted Map<String, String> files);

  private final Map<String, String> files;
  @AssistedInject
  PushOneCommit(ChangeNotes.Factory notesFactory,
      ApprovalsUtil approvalsUtil,
      Provider<InternalChangeQuery> queryProvider,
      @Assisted ReviewDb db,
      @Assisted PersonIdent i,
      @Assisted TestRepository<?> testRepo,
      @Assisted("changeId") String changeId) throws Exception {
    this(notesFactory, approvalsUtil, queryProvider,
        db, i, testRepo, SUBJECT, FILE_NAME, FILE_CONTENT, changeId);
  }

  @AssistedInject
  PushOneCommit(ChangeNotes.Factory notesFactory,
      ApprovalsUtil approvalsUtil,
      Provider<InternalChangeQuery> queryProvider,
      @Assisted ReviewDb db,
      @Assisted PersonIdent i,
      @Assisted TestRepository<?> testRepo,
      @Assisted String subject,
      @Assisted Map<String, String> files) throws Exception {
    this(notesFactory, approvalsUtil, queryProvider, db, i, testRepo,
        subject, files, null);
  }

    this(notesFactory, approvalsUtil, queryProvider, db, i, testRepo,
        subject, ImmutableMap.of(fileName, content), changeId);
  }

  private PushOneCommit(ChangeNotes.Factory notesFactory,
      ApprovalsUtil approvalsUtil,
      Provider<InternalChangeQuery> queryProvider,
      ReviewDb db,
      PersonIdent i,
      TestRepository<?> testRepo,
      String subject,
      Map<String, String> files,
      String changeId) throws Exception {
    this.files = files;
      .committer(new PersonIdent(i, testRepo.getDate()));
  public void setParent(RevCommit parent) throws Exception {
    commitBuilder.noParents();
    commitBuilder.parent(parent);
  }

    for (Map.Entry<String, String> e : files.entrySet()) {
      commitBuilder.add(e.getKey(), e.getValue());
    }
    for (String fileName : files.keySet()) {
      commitBuilder.rm(fileName);
    }
  public void noParents() {
    commitBuilder.noParents();
  }

        throws OrmException, NoSuchChangeException {
        throws OrmException, NoSuchChangeException {
      Iterable<Account.Id> actualIds = approvalsUtil
          .getReviewers(db, notesFactory.createChecked(db, c))
          .all();
    public String getMessage() {
      RemoteRefUpdate refUpdate = result.getRemoteUpdate(ref);
      return message(refUpdate);
    }
