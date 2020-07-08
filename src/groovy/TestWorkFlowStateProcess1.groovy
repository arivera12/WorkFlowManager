class TestWorkFlowStateProcess1
        extends WorkFlowStateProcess<TestWorkflowModel, TestState>
        implements IWorkFlowStateProcess<TestWorkflowModel, TestState>
{
    TestWorkFlowStateProcess1(TestWorkflowModel testWorkflowModel)
    {
        record = testWorkflowModel;
        currentState = TestState.Step0;
        nextState = TestState.Step1;
    }
    @Override
    boolean proceedNextStateProcessWhen()
    {
        //some validation steps then false!
        return false
    }
    @Override
    TestWorkflowModel proceedNextStateProcess()
    {
        //We process our record and call our services then we change state
        record.testState = nextState;
        return record;
    }
}
