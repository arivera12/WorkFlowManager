static void main(String[] args)
{
    TestWorkflowModel testWorkflowModel = new TestWorkflowModel()
    testWorkflowModel.myProperty = "test"
    testWorkflowModel.testState = TestState.Step0
    TestWorkFlowManager testWorkFlowManager = new TestWorkFlowManager(testWorkflowModel)
    testWorkFlowManager.runWorkFlowProcess();
}