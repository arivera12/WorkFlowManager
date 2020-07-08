class TestWorkFlowStateProcess2
        extends WorkFlowStateProcess<TestWorkflowModel, TestState>
        implements IWorkFlowStateProcess<TestWorkflowModel, TestState>
{
    TestWorkFlowStateProcess2(TestWorkflowModel testWorkflowModel)
    {
        record = testWorkflowModel;
        currentState = TestState.Step0;
        nextState = TestState.Step2;
    }
    @Override
    boolean proceedNextStateProcessWhen()
    {
        //some validation steps then true!
        return true
    }
    @Override
    TestWorkflowModel proceedNextStateProcess()
    {
        //We process our record and call our services then we change state
        record.testState = nextState;
        return record;
    }
}
