import { AppPage } from './app.po';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('displays title', () => {
    page.navigateTo();

    expect(page.getParagraphText()).toEqual('Movie Ranker');
  });
});