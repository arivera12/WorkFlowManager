class TestWorkFlowManager
        extends WorkFlowManager<TestWorkflowModel, TestState>
        implements IWorkFlowManager<TestWorkflowModel>
{
    TestWorkFlowManager(TestWorkflowModel record)
    {
        this.record = record
        this.statePropertyName = "testState"
        this.workFlowStateProcesses = new ArrayList<WorkFlowStateProcess<TestWorkflowModel, TestState>>()
        this.workFlowStateProcesses.add(new TestWorkFlowStateProcess1(record))
        this.workFlowStateProcesses.add(new TestWorkFlowStateProcess2(record))
    }
}
