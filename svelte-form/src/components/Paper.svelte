<div class='page'>
  <span class="spacer"/>
  <div class="paper">
    <slot/>
  </div>
  <span class="spacer"/>
</div>

<style>
  .page {
    font-family: Arial, Helvetica, sans-serif;  
    display: flex;
    flex-direction: row;
    flex-grow: 1;
    align-items: top;    
    justify-content: center;
  }

  .paper {
    padding-left: 48px;
    padding-right: 48px;
    display: flex;
    flex-grow: 0;
    min-width: 800px;
    height: 100vh;
    flex-direction: column;
    align-items: left;
    justify-content: top;
    background: #fff;
  }

  .spacer {
    display: flex;
    flex-grow: 1;
  }
</style>